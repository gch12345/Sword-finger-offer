#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<math.h>
//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
//使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

int cmp(void* a, void* b)
{
	return (*(int*)a - *(int*)b);
}
int threeSumClosest(int* nums, int numsSize, int target){
	assert(nums != NULL);
	qsort(nums, numsSize, sizeof(int), cmp);
	int *Left = NULL;
	int *Right = NULL;
	int i = 0;
	int re = nums[0] + nums[1] + nums[2];
	for (i = 0; i < numsSize; i++)
	{
		Left = nums + i + 1;
		Right = numsSize + nums - 1;
		while(Left < Right)
		{
			if (nums[i] + *Left + *Right>=target)
			{
				if (abs(re - target)>abs(nums[i] + *Left + *Right - target))
					re = nums[i] + *Left + *Right;
				Right--;
			}
			else
			{
				if (abs(re - target)>abs(nums[i] + *Left + *Right - target))
					re = nums[i] + *Left + *Right;
				Left++;
			}
		}
	}
	return re;
}