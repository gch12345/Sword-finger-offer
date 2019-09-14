#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//你可以假设数组中无重复元素
int searchInsert(int* nums, int numsSize, int target){
	if (numsSize == 0)
	{
		return 0;
	}
	int left = 0;
	int right = numsSize - 1;
	while (left <= right)
	{
		int mid = left + right;
		if (target > nums[mid])
		{
			left = mid + 1;
		}
		else if (target < nums[mid])
		{
			right = mid - 1;
		}
		else if (target == nums[mid])
		{
			return mid;
		}
	}
	return left;
}

