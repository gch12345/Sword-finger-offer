#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<assert.h>
#include<stdlib.h>
int cmp(const void *a, const void *b)
{
	return (*(const int*)a - *(const int*)b);
}
int** threeSum(int* nums, int numsSize, int* returnSize, int** returnColumnSizes){
	assert(nums != NULL&&returnSize != NULL);
	qsort(nums, numsSize, sizeof(int), cmp);
	int i = 0;
	int *Left = NULL;
	int *Right = NULL;
	*returnSize = 0;
	int **res = (int**)malloc(sizeof(int*));
	(*returnColumnSizes) = (int*)malloc(1*sizeof(int));
	for (; i < numsSize - 2; i++)
	{
		if (nums[i] >= 0)
			break;
		if (nums[i] == nums[i + 1])
			continue;
		int *p = NULL;
		Left = nums + 1 + i;
		Right = nums + numsSize - 1;
		while (Left<Right)
		{
			if (nums[i] + *Left + *Right > 0)
			{
				while (*Right == *(Right - 1)&&Left < Right)
					Right--;
				Right--;
			}
			else if (nums[i] + *Left + *Right < 0)
			{
				while (*Left == *(Left + 1) && Left < Right)
					Left++;
				Left++;
			}
			else
			{
				res = (int**)realloc(res, ((*returnSize) + 1)*sizeof(int*));
				res[*returnSize] = (int *)malloc(sizeof(int)*3);
				res[*returnSize][0] = nums[i];
				res[*returnSize][1] = nums[*Left];
				res[*returnSize][2] = nums[*Right];
				/*p = (int*)malloc(sizeof(int)* 3);
				p[0] = nums[i];
				p[1] = nums[*Left];
				p[2] = nums[*Right];*/
				(*returnColumnSizes) = (int *)realloc((*returnColumnSizes), ((*returnSize) + 1)*sizeof(int));
				(*returnColumnSizes)[*returnSize] = 3;
				(*returnSize)++;
				Left++;
				Right--;
			}
		}
	}
	return res;
}

int main()
{
	int num = 0;
	int arr[] = { -1, 0, 1, 2, -1, -4 };
	int i = 0;
	int*p = &i;
	int **returnSize = &p;
	int**re=threeSum(arr, 5, &num, returnSize);
	
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