#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
//����һ������ candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�
//
//candidates �е�ÿ��������ÿ�������ֻ��ʹ��һ��
//�������֣�����Ŀ������������������
//�⼯���ܰ����ظ�����ϡ�
//re:���ص����顣 sum:��ǰ���ֵĺ͡� map:��ʱ������ n:ÿ�����ݵĴ�С�� num:ȥ֦Ҷ
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
//����һ�����ظ�Ԫ�ص����� candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�
//
//candidates �е����ֿ����������ظ���ѡȡ��

int cmp(const void*a, const void*b)
{
	return *(int*)a - *(int*)b;
}
//re:���ص����顣 sum:��ǰ���ֵĺ͡� map:��ʱ������ n:ÿ�����ݵĴ�С�� num:ȥ֦Ҷ
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
