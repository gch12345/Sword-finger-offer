#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
//����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ�������������������Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
//����Լ������������ظ�Ԫ��
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

