#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
*/
int trap(int* height, int heightSize){
	if (heightSize <= 1)
		return 0;
	int *pHeight = height;
	while (*pHeight == 0)
		pHeight++;
	int re = 0;
	int *qHeight = pHeight + 1;
	while (height + heightSize > qHeight)
	{
		while (height + heightSize > qHeight&&*qHeight < *pHeight)
			qHeight++;
		if (qHeight == height + heightSize)
			break;
		re = re + *pHeight*(qHeight - pHeight);
		while (pHeight != qHeight)
		{
			re = re - *pHeight;
			pHeight++;
		}
		qHeight++;
	}
	if (pHeight != qHeight)
	{
		int * heightHeight = pHeight;
		qHeight--;
		pHeight = qHeight - 1;
		while (pHeight > heightHeight)
		{
			while (pHeight >= heightHeight&&*pHeight < *qHeight)
			{
				pHeight--;
			}
			if (pHeight == heightHeight - 1)
				break;
			re = re + *qHeight*(qHeight - pHeight);
			while (pHeight != qHeight)
			{
				re = re - *qHeight;
				qHeight--;
			}
			pHeight--;
		}
	}
	return re;
}
int main()
{
	int arr[] = { 4,2,3 };
	int re = trap(arr, sizeof(arr) / sizeof(arr[0]));
	printf("%d\n", re);
	system("pause");
	return 0;
}