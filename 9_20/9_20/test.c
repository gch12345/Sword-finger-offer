#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//candidates 中的每个数字在每个组合中只能使用一次
//所有数字（包括目标数）都是正整数。
//解集不能包含重复的组合。
//re:返回的数组。 sum:当前数字的和。 map:临时容器。 n:每组数据的大小。 num:去枝叶
void fun0(int* candidates, int candidatesSize, int target, int* returnSize, int** re, int sum, int *map, int n, int**returnColumnSizes, int num)
{
	if (sum > target&&n>0)
		return;
	if (sum == target)
	{
		re[*returnSize] = (int*)malloc(sizeof(int)*n);
		for (int i = 0; i < n; i++)
		{
			re[*returnSize][i] = map[i];
		}
		(*returnColumnSizes)[*returnSize] = n;
		(*returnSize)++;
		return;
	}

	for (int j = num; j < candidatesSize; j++)
	{
		sum += candidates[j];
		map[n] = candidates[j];
		fun(candidates, candidatesSize, target, returnSize, re, sum, map, n + 1, returnColumnSizes, j + 1);
		sum -= candidates[j];
		while (j<candidatesSize - 1 && candidates[j] == candidates[j + 1])
			j++;
	}
}
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//candidates 中的数字可以无限制重复被选取。

int cmp(const void*a, const void*b)
{
	return *(int*)a - *(int*)b;
}
//re:返回的数组。 sum:当前数字的和。 map:临时容器。 n:每组数据的大小。 num:去枝叶
void fun(int* candidates, int candidatesSize, int target, int* returnSize, int** re, int sum, int *map, int n, int**returnColumnSizes, int num)
{
	if (sum > target&&n>0)
		return;
	if (sum == target)
	{
		re[*returnSize] = (int*)malloc(sizeof(int)*n);
		for (int i = 0; i < n; i++)
		{
			re[*returnSize][i] = map[i];
		}
		(*returnColumnSizes)[*returnSize] = n;
		(*returnSize)++;
		return;
	}

	for (int j = num; j < candidatesSize; j++)
	{
		sum += candidates[j];
		map[n] = candidates[j];
		fun(candidates, candidatesSize, target, returnSize, re, sum, map, n + 1, returnColumnSizes, j);
		sum -= candidates[j];
	}
}

int** combinationSum(int* candidates, int candidatesSize, int target, int* returnSize, int** returnColumnSizes){
	int**re = (int**)malloc(sizeof(int*)* 500);
	*returnColumnSizes = (int*)malloc(sizeof(int)* 500);
	int *map = (int*)malloc(sizeof(int)* 500);
	qsort(candidates, candidatesSize, sizeof(int), cmp);
	*returnSize = 0;
	fun(candidates, candidatesSize, target, returnSize, re, 0, map, 0, returnColumnSizes, 0);
	return re;
}

int main()
{
	int arr[] = { 2, 3, 6, 7 };
	int *x = (int*)malloc(sizeof(int));
	int** p = (int**)malloc(sizeof(int*));
	int** re=combinationSum(arr, 4, 7, x, p);
	for (int i = 0; i < *x; i++)
	{
		for (int j = 0; j < (*p)[i]; j++)
		{
			printf("%d ", re[i][j]);
		}
	}
	system("pause");
	return 0;
}
