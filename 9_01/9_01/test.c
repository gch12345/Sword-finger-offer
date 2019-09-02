#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<assert.h>
#include<stdlib.h>

//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//注意：答案中不可以包含重复的三元组。

int cmp(const void *a, const void *b)
{
	return (*(const int*)a - *(const int*)b);
}
int** threeSum(int* nums, int numsSize, int* returnSize, int** returnColumnSizes){
	assert(nums != NULL&&returnSize != NULL&&returnColumnSizes != NULL);
	qsort(nums, numsSize, sizeof(int), cmp);
	int i = 0;
	int *Left = NULL;
	int *Right = NULL;
	*returnSize = 0;
	*returnColumnSizes = (int *)malloc(sizeof(int)* numsSize * numsSize);
	int **res = (int**)malloc(sizeof(int *)* numsSize * numsSize);
	(*returnColumnSizes) = (int*)malloc(1 * sizeof(int));
	for (; i < numsSize - 2; i++)
	{
		if (nums[i] > 0)
			break;
		int *p = NULL;
		Left = nums + 1 + i;
		Right = nums + numsSize - 1;
		if (*Right<0)
			break;
		if (nums[i] + *Right + *(Right - 1)<0)
			continue;
		while (Left<Right)
		{
			while (Left < Right&& *Left == *(Left + 1) && 2 * (*Left) != -nums[i])
				Left++;
			while (*Right == *(Right - 1) && Left < Right && 2 * (*Right) != -nums[i])
				Right--;
			if (nums[i] + *Left + *Right > 0)
			{
				Right--;
				if (*Right<0)
					break;
			}
			else if (nums[i] + *Left + *Right < 0)
			{

				Left++;
			}
			else
			{
				res[*returnSize] = (int *)malloc(3 * sizeof(int));
				res[*returnSize][0] = nums[i];
				res[*returnSize][1] = *Left;
				res[*returnSize][2] = *Right;
				(*returnColumnSizes)[*returnSize] = 3;
				(*returnSize)++;
				if (*Left == *Right)
					Left = Right;
				Left++;
				Right--;
			}
		}
		while (nums[i] == nums[i + 1] && i < numsSize - 2)
			i++;
	}
	return res;
}


int main()
{
	int num = 0;
	int arr[] = { 0, 2, 2, 3, 0, 1, 2, 3, -1, -4, 2 };
	int i = 0;
	int*p = &i;
	int **returnSize = &p;
	qsort(arr, sizeof(arr)/sizeof(int), sizeof(int), cmp);
	int**re = threeSum(arr, sizeof(arr) / sizeof(int), &num, returnSize);
}

#if 0
//编写一个函数来查找字符串数组中的最长公共前缀。
//如果不存在公共前缀，返回空字符串 ""。
char * longestCommonPrefix(char ** strs, int strsSize){
	if (strsSize == 0)
		return "";
	else if (strsSize == 1)
		return *strs;
	int i = 0;
	for (; i < strsSize - 1; i++)
	{
		int j = 0;
		while (strs[0][j] == strs[i + 1][j] && strs[i + 1][j] != '\0')
		{
			j++;
		}
		strs[0][j] = '\0';
		if (strs[0][0] == '\0')
			break;
	}
	return strs[0];
}
int main()
{
	char str1[] = "a";
	char str2[] = "aca";
	char str3[] = "accb";
	char str4[] = "b";
	char *p[4] = { str1, str2, str3, str4 };
	printf("%s",longestCommonPrefix(p, 4));
	system("pause");
	return 0;
}
#endif