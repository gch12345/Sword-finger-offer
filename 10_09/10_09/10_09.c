#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
void fun(char ***ret, int n, int num, int *returnSize, int **returnColumnSizes, char** board, int row){
	for (int a = row; a < num; a++){
		int count = 0;
		for (int b = 0; b < num; b++){
			if (board[a][b] != 0)
				count++;
		}
		if (count == num)
			return;
	}
	if (n == 0){
		ret[*returnSize] = (char**)malloc(sizeof(char*)* num);
		for (int i = 0; i < num; i++){
			ret[*returnSize][i] = (char*)malloc(sizeof(char)* num + 1);
			ret[*returnSize][i][num] = '\0';
			for (int j = 0; j < num; j++){
				if (board[i][j] == -1){
					ret[*returnSize][i][j] = 'Q';
				}
				else{
					ret[*returnSize][i][j] = '.';
				}
			}
		}
		returnColumnSizes[0][*returnSize] = num;
		(*returnSize)++;
		return;
	}
	int i = row;
	for (int j = 0; j < num; j++){
		if (board[i][j] == 0){
			for (int a = 0; a < num; a++){
				for (int b = 0; b < num; b++){
					if ((((a + b) == (i + j)) || ((a - b) == (i - j))) && (board[a][b] == 0)){
						board[a][b] = n;
					}
				}
			}
			for (int k = 0; k < num; k++){
				if ((board[i][k] == 0) && (board[i][k] != -1)){
					board[i][k] = n;
				}
				if ((board[k][j] == 0) && (board[k][j] != -1)){
					board[k][j] = n;
				}
			}
			board[i][j] = -1;
			fun(ret, n - 1, num, returnSize, returnColumnSizes, board, row + 1);
			board[i][j] = 0;
			for (int a = 0; a < num; a++){
				for (int b = 0; b < num; b++){
					if (board[a][b] == n){
						board[a][b] = 0;
					}
				}
			}
		}
	}
}

char *** solveNQueens(int n, int* returnSize, int** returnColumnSizes){
	char *** ret = (char***)malloc(sizeof(char**)* 500);
	char ** board = (char**)malloc(sizeof(char*)* n);
	for (int i = 0; i < n; i++){
		board[i] = (char*)calloc(n, sizeof(char));
	}
	*returnSize = 0;
	*returnColumnSizes = (int*)malloc(500 * sizeof(int));
	fun(ret, n, n, returnSize, returnColumnSizes, board, 0);
	return ret;
}
int main()
{
	int returnSize = 0;
	int* returnColumnSizes = NULL;
	char *** re = solveNQueens(9, &returnSize, &returnColumnSizes);
	for (int i = 0; i < returnSize; i++){
		for (int j = 0; j < 9; j++){
			for (int k = 0; k < 9; k++){
				printf("%c,", re[i][j][k]);
			}
			printf("\n");
		}
		printf("\n");
	}
	system("pause");
	return 0;
}


int g_rstNum = 0;

int check(int x, int y)
{
	if (x == 0 || y == 0) {
		return false;
	}

	if (x == y) {
		return false;
	}

	return true;
}

void dfs(int n, int *tempArray, int depth)
{
	// save
	if (depth == n) {
		g_rstNum++;
	}

	// for dfs
	int j = 0;
	int x, y;
	for (j = 0; j < n; j++) {

		// check
		int rst = true;
		for (int k = 0; k < depth; k++) {
			x = abs(depth - k);
			y = abs(j - tempArray[k]);

			rst = check(x, y);
			if (rst == false) {
				break;
			}
		}

		// dfs continue
		if (rst == true) {
			tempArray[depth] = j;
			dfs(n, tempArray, depth + 1);
		}
	}


}

int totalNQueens(int n){

	// init
	int *tempArray = (int*)malloc(sizeof(int)* n);
	memset(tempArray, 0, sizeof(int)* n);
	g_rstNum = 0;

	// dfs
	dfs(n, tempArray, 0);

	// return
	return g_rstNum;
}