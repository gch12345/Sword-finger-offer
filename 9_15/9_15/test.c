#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
//1.数字 1 - 9 在每一行只能出现一次。
//2.数字 1 - 9 在每一列只能出现一次。
//3.数字 1 - 9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

bool isValidSudoku(char** board, int boardSize, int* boardColSize){
	int row[9][9] = { 0 };
	int col[9][9] = { 0 };
	int box[9][9] = { 0 };
	for (int i = 0; i < boardSize / (*boardColSize); i++)
	{
		for (int j = 0; j < *boardColSize; j++)
		{
			if (board[i][j] != '.')
			{
				if (row[i][board[i][j] - '0'] != 1)
					row[i][board[i][j] - '0'] == 1;
				else
					return false;
				if (col[j][board[i][j] - '0'] != 1)
					col[j][board[i][j] - '0'] == 1;
				else
					return false;
				if (box[(i / 3) * 3 + j / 3][board[i][j] - '0'] != 1)
					box[(i / 3) * 3 + j / 3][board[i][j] - '0'] == 1;
				else
					return false;
			}
		}
	}
	return true;
}