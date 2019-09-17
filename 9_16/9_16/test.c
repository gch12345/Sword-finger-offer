#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
//编写一个程序，通过已填充的空格来解决数独问题。
//一个数独的解法需遵循如下规则：
//数字 1 - 9 在每一行只能出现一次。
//数字 1 - 9 在每一列只能出现一次。
//数字 1 - 9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//
//空白格用 '.' 表示。

char board0[9][9] = { 0 };
void isFill(int row[9][9], int col[9][9], int box[9][9], char **board, int fillNumb)
{
	while (fillNumb < 81 && board[fillNumb / 9][fillNumb % 9] != '.')
	{
		board0[fillNumb / 9][fillNumb % 9] = board[fillNumb / 9][fillNumb % 9];
		fillNumb++;
	}

	if (fillNumb >= 81)
	{
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				board[i][j] = board0[i][j];
			}
		}
		return;
	}
	for (int i = 0; i < 9; i++)
	{
		if (row[fillNumb / 9][i] != 1 && col[fillNumb % 9][i] != 1 && box[(fillNumb / 9) / 3 * 3 + (fillNumb % 9) / 3][i] != 1)
		{
			board0[fillNumb / 9][fillNumb % 9] = '0' + i + 1;
			row[fillNumb / 9][i] = 1;
			col[fillNumb % 9][i] = 1;
			box[(fillNumb / 9) / 3 * 3 + (fillNumb % 9) / 3][i] = 1;
			isFill(row, col, box, board, fillNumb + 1);
			//board[fillNumb / 9][fillNumb % 9] = '.';
			row[fillNumb / 9][i] = 0;
			col[fillNumb % 9][i] = 0;
			box[(fillNumb / 9) / 3 * 3 + (fillNumb % 9) / 3][i] = 0;
		}
	}
}
void solveSudoku(char** board, int boardSize, int* boardColSize)
{
	int row[9][9] = { 0 };
	int col[9][9] = { 0 };
	int box[9][9] = { 0 };
	for (int i = 0; i < 9; i++)
	{
		for (int j = 0; j < 9; j++)
		{
			if (board[i][j] != '.')
			{
				row[i][board[i][j] - '0' - 1] = 1;
				col[j][board[i][j] - '0' - 1] = 1;
				box[(i / 3) * 3 + j / 3][board[i][j] - '0' - 1] = 1;
			}
		}
	}
	isFill(row, col, box, board, 0);

}
char board0[9][9] = { 0 };
void isFill(int row[9][9], int col[9][9], int box[9][9], char **board, int fillNumb)
{
	while (fillNumb < 81 && board[fillNumb / 9][fillNumb % 9] != '.')
	{
		//board0[fillNumb / 9][fillNumb % 9] = board[fillNumb / 9][fillNumb % 9];
		fillNumb++;
	}

	if (fillNumb >= 81)
	{
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				board0[i][j] = board[i][j];
			}
		}
		return;
	}
	for (int i = 0; i < 9; i++)
	{
		if (row[fillNumb / 9][i] != 1 && col[fillNumb % 9][i] != 1 && box[(fillNumb / 9) / 3 * 3 + (fillNumb % 9) / 3][i] != 1)
		{
			board[fillNumb / 9][fillNumb % 9] = '0' + i + 1;
			row[fillNumb / 9][i] = 1;
			col[fillNumb % 9][i] = 1;
			box[(fillNumb / 9) / 3 * 3 + (fillNumb % 9) / 3][i] = 1;
			isFill(row, col, box, board, fillNumb + 1);
			board[fillNumb / 9][fillNumb % 9] = '.';
			row[fillNumb / 9][i] = 0;
			col[fillNumb % 9][i] = 0;
			box[(fillNumb / 9) / 3 * 3 + (fillNumb % 9) / 3][i] = 0;
		}
	}
}
//void solveSudoku(char** board, int boardSize, int* boardColSize)
//{
//	int row[9][9] = { 0 };
//	int col[9][9] = { 0 };
//	int box[9][9] = { 0 };
//	for (int i = 0; i < 9; i++)
//	{
//		for (int j = 0; j < 9; j++)
//		{
//			if (board[i][j] != '.')
//			{
//				row[i][board[i][j] - '0' - 1] = 1;
//				col[j][board[i][j] - '0' - 1] = 1;
//				box[(i / 3) * 3 + j / 3][board[i][j] - '0' - 1] = 1;
//			}
//		}
//	}
//	isFill(row, col, box, board, 0);
//	for (int i = 0; i < 9; i++)
//	{
//		for (int j = 0; j < 9; j++)
//		{
//			board[i][j] = board0[i][j];
//		}
//	}
//}

int main()
{
	char s0[9] = { '5', '3', '.', '.', '7', '.', '.', '.', '.' };
	char s1[9] = { '6', '.', '.', '1', '9', '5', '.', '.', '.' };
	char s2[9] = { '.', '9', '8', '.', '.', '.', '.', '6', '.' };
	char s3[9] = { '8', '.', '.', '.', '6', '.', '.', '.', '3' };
	char s4[9] = { '4', '.', '.', '8', '.', '3', '.', '.', '1' };
	char s5[9] = { '7', '.', '.', '.', '2', '.', '.', '.', '6' };
	char s6[9] = { '.', '6', '.', '.', '.', '.', '2', '8', '.' };
	char s7[9] = { '.', '.', '.', '4', '1', '9', '.', '.', '5' };
	char s8[9] = { '.', '.', '.', '.', '8', '.', '.', '7', '9' };
	char*p[9] = { s0, s1, s2, s3, s4, s5, s6, s7, s8 };
	int x = 0;
	solveSudoku(p, 0, &x);
	/*	[["5", "3", ".", ".", "7", ".", ".", ".", "."],
		["6", ".", ".", "1", "9", "5", ".", ".", "."],
		[".", "9", "8", ".", ".", ".", ".", "6", "."], 
		["8", ".", ".", ".", "6", ".", ".", ".", "3"], 
		["4", ".", ".", "8", ".", "3", ".", ".", "1"],
		["7", ".", ".", ".", "2", ".", ".", ".", "6"], 
		[".", "6", ".", ".", ".", ".", "2", "8", "."], 
		[".", ".", ".", "4", "1", "9", ".", ".", "5"], 
		[".", ".", ".", ".", "8", ".", ".", "7", "9"]]*/
}