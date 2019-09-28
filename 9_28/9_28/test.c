#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//给定一个没有重复数字的序列，返回其所有可能的全排列。
void fun(int* nums, int numsSize, int**re, int* returnSize, int**returnColumnSizes, int* arr){
	if (nums == NULL)
	{
		for (int i = 0; i < sizeof(arr) / sizeof(arr[0]); i++)
		{
			re[*returnSize][i] = arr[i];
		}
		(*returnColumnSizes)[*returnSize] = sizeof(arr) / sizeof(arr[0]);
		(*returnSize)++;
		return;
	}
	for (int i = sizeof(arr) / sizeof(arr[0]) - numsSize; i < sizeof(arr) / sizeof(arr[0]); i++)
	{
		for (int j = 0; j < sizeof(arr) / sizeof(arr[0]); j++)
		{
			arr[i] = nums[j];
			fun(nums + 1, numsSize - 1, re, returnSize, returnColumnSizes, arr);
		}
	}
}

int** permute(int* nums, int numsSize, int* returnSize, int** returnColumnSizes){
	int len = 1;
	for (int i = 1; i <= numsSize; i++)
		len *= i;
	int** re = (int**)malloc(len * sizeof(int*));
	for (int i = 0; i < len; i++)
		re[i] = (int*)malloc(sizeof(int)* numsSize);
	int* arr = (int*)malloc(sizeof(int)* numsSize);
	fun(nums, numsSize, re, returnSize, returnColumnSizes, arr);
	return re;
}
