#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
//�ж�һ�� 9x9 �������Ƿ���Ч��ֻ��Ҫ�������¹�����֤�Ѿ�����������Ƿ���Ч���ɡ�
//1.���� 1 - 9 ��ÿһ��ֻ�ܳ���һ�Ρ�
//2.���� 1 - 9 ��ÿһ��ֻ�ܳ���һ�Ρ�
//3.���� 1 - 9 ��ÿһ���Դ�ʵ�߷ָ��� 3x3 ����ֻ�ܳ���һ�Ρ�

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