#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int* searchRange(int* nums, int numsSize, int target, int* returnSize){
	int left = 0;
	int right = numsSize - 1;
	int *re = (int*)malloc(sizeof(int)* 2);
	*returnSize = 2;
	if (numsSize <= 1)
	{
		re[0] = 0;
		re[1] = 0;
		return re;
	}
	while (left <= right)
	{
		int mid = (left + right) / 2;
		if (nums[mid] == target)
		{
			int tmp = mid;
			while (mid>0&&nums[mid] == nums[mid - 1])
				mid--;
			re[0] = mid;
			while (tmp<numsSize&&nums[tmp] == nums[tmp + 1])
			{
				tmp++;
			}
			re[1] = tmp;
			return re;
		}
		if (target > nums[mid])
		{
			left = mid + 1;
		}
		else
		{
			right = mid - 1;
		}
	}
	re[0] = -1;
	re[1] = -1;
	return re;
}
int main()
{
	int arr[] = { 5, 7, 7, 8, 8, 10 };
	int a = 0;
	searchRange(arr, 6, 8, &a);
}