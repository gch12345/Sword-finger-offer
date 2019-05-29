#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

//汉诺塔问题。
//void play(int n,char a,char b,char c)
//{
//	if (n == 1)
//	{
//		printf("%c->%c\n", a, c);
//	}
//	else
//	{
//		play(n - 1, a, c, b);
//		printf("%c->%c\n", a, c);
//		play(n - 1, b, a, c);
//	}
//}
//
//int main()
//{
//	int n = 0;
//	scanf("%d", &n);
//	play(n, 'A', 'B', 'C');
//	system("pause");
//	return 0;
//}

//在一个二维数组中（每个一维数组的长度相同），
//每一行都按照从左到右递增的顺序排序，
//每一列都按照从上到下递增的顺序排序。
//请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
int exist(int arr[4][4], int row, int col, int a)
{
	int i = 0;
	while (1)
	{
		if (arr[row-1][i] == a)
		{
			return 1;
		}
		else
		{
			if (arr[row-1][i] > a)
			{
				row--;
			}
			else 
			{
				i++;
			}
			if (row < 0 || i >= col)
			{
				return 0;
			}
		}
	}
}

int main()
{
	int a = 5;
	int arr[4][4] = { { 1, 2, 3, 4 }, { 2, 3, 4, 5 }, { 3, 4, 5, 6 }, { 4, 5, 6, 7 } };
	int sz = sizeof(arr) / sizeof(arr[0][0]);
	int row = sizeof(arr) / sizeof(arr[0]);
	int col = sz / row;
	int k = 0;
	k = exist(arr, row, col, a);
	if (k)
	{
		printf("存在\n");
	}
	else
	{
		printf("没有找到\n");
	}
	system("pause");
	return 0;
}