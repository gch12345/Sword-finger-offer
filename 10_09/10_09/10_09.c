#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
void fun(char ***ret, int n, int num, int *returnSize, int **returnColumnSizes, int** board){
	if (n == 0){
		ret[*returnSize] = (char**)malloc(sizeof(char*)* num);
		for (int i = 0; i < num; i++){
			ret[*returnSize][i] = (char*)malloc(sizeof(char)* num);
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
	for (int i = 0; i < num; i++){
		for (int j = 0; j < num; j++){
			if (board[i][j] == 0){
				for (int a = 0; a < num; a++){
					for (int b = 0; b < num; b++){
						if (a + b == i + j || a - b == i - j && board[a][b] != -1){
							board[a][b] = 1;
						}
					}
				}
				for (int k = 0; k < num; k++){
					if (board[i][k] != -1)
						board[i][k] = 1;
					if (board[k][j] != -1)
						board[k][j] = 1;
				}
				board[i][j] = -1;
				fun(ret, n - 1, num, returnSize, returnColumnSizes, board);
				board[i][j] = 0;
				for (int a = 0; a < num; a++){
					for (int b = 0; b < num; b++){
						if (a + b == i + j || a - b == i - j && board[a][b] != -1){
							board[a][b] = 0;
						}
					}
				}
				for (int k = 0; k < num; k++){
					if (board[i][k] != -1)
						board[i][k] = 0;
					if (board[k][j] != -1)
						board[k][j] = 0;
				}
				for (int h = 0; h < num; h++){
					for (int g = 0; g < num; g++){
						if (board[h][g] == -1){
							for (int a = 0; a < num; a++){
								for (int b = 0; b < num; b++){
									if (a + b == h + g || a - b == h - g && board[a][b] != -1){
										board[a][b] = 1;
									}
								}
							}
							for (int k = 0; k < num; k++){
								if (board[h][k] != -1)
									board[h][k] = 1;
								if (board[k][g] != -1)
									board[k][g] = 1;
							}
						}
					}
				}
			}
		}
	}
}

char *** solveNQueens(int n, int* returnSize, int** returnColumnSizes){
	char *** ret = (char***)malloc(sizeof(char**)* 2000);
	int ** board = (int**)malloc(sizeof(int*)* n);
	for (int i = 0; i < n; i++){
		board[i] = (int*)calloc(n, sizeof(int));
	}
	*returnSize = 0;
	*returnColumnSizes = (int*)malloc(2000 * sizeof(int));
	fun(ret, n, n, returnSize, returnColumnSizes, board);
	return ret;
}

