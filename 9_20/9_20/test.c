#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int cmp(const void*a, const void*b)
{
	return *(int*)a - *(int*)b;
}
void fun(int* candidates, int candidatesSize, int target, int* returnSize, int** returnColumnSizes, int sum, int*map, int n)
{
	if (sum > target)
		return;
	if (sum == target)
	{
		returnColumnSizes[*returnSize] = (int*)malloc(sizeof(int)*n);
		for (int i = 0; i < n; i++)
		{
			returnColumnSizes[*returnSize][i] = map[i];
		}
		(*returnSize)++;
		return;
	}
	for (int i = 0; i < candidatesSize; i++)
	{
		for (int j = i; j < candidatesSize; j++)
		{
			sum += candidates[j];
			map[n] = candidates[j];
			fun(candidates, candidatesSize, target, returnSize, returnColumnSizes, sum, map, n + 1);
			sum -= candidates[j];
		}
	}
}
int** combinationSum(int* candidates, int candidatesSize, int target, int* returnSize, int** returnColumnSizes){
	int**re = (int**)malloc(sizeof(int*)* 10000);
	int *map = (int*)malloc(sizeof(int)* 10000);
	qsort(candidates, candidatesSize, sizeof(int), cmp);
	*returnSize = 0;
	fun(candidates, candidatesSize, target, returnSize, re, 0, map, 0);
	return re;
}
int cmp(const void*a, const void*b)
{
	return *(int*)a - *(int*)b;
}
void fun(int* candidates, int candidatesSize, int target, int* returnSize, int** returnColumnSizes, int sum, int*map, int n, int**re, int num)
{
	if (sum > target)
		return;
	if (sum == target)
	{
		returnColumnSizes[*returnSize] = (int*)malloc(sizeof(int)*n);
		for (int i = 0; i < n; i++)
		{
			returnColumnSizes[*returnSize][i] = map[i];
		}
		re[*returnSize] = (int*)malloc(sizeof(int));
		re[*returnSize][0] = n;
		(*returnSize)++;
		return;
	}

	for (int j = num; j < candidatesSize; j++)
	{
		sum += candidates[j];
		map[n] = candidates[j];
		fun(candidates, candidatesSize, target, returnSize, returnColumnSizes, sum, map, n + 1, re, j);
		sum -= candidates[j];
	}
}

int** combinationSum(int* candidates, int candidatesSize, int target, int* returnSize, int** returnColumnSizes){
	int**re = (int**)malloc(sizeof(int*)* 10000);
	returnColumnSizes = (int**)malloc(sizeof(int*)* 10000);
	int *map = (int*)malloc(sizeof(int)* 10000);
	qsort(candidates, candidatesSize, sizeof(int), cmp);
	*returnSize = 0;
	fun(candidates, candidatesSize, target, returnSize, re, 0, map, 0, returnColumnSizes, 0);
	return re;
}

int main()
{
	int arr[] = { 2, 3, 6, 7 };
	int x = 0;
	int *p = &x;
	combinationSum(arr, 4, 7, p, &p);
}
