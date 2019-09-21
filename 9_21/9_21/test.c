#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
int firstMissingPositive(int* nums, int numsSize){
	for (int i = 0; i < numsSize; i++)
	{
		if (nums[i] != i + 1 && nums[i] <= numsSize&&nums[i]>0 && nums[i] != nums[nums[i] - 1])
		{
			int tmp = nums[i];
			nums[i] = nums[tmp - 1];
			nums[tmp - 1] = tmp;
			i--;
		}
	}
	int j = 0;
	for (; j < numsSize; j++)
	{
		if (nums[j] != j + 1)
			break;
	}
	if (j == numsSize)
		return numsSize + 1;
	else
		return j + 1;
}
int main()
{
	int arr[] = { 1, -1, 3, 4, 6, 7 };
	int re = firstMissingPositive(arr, sizeof(arr) / sizeof(arr[0]));
	printf("%d\n", re);
	system("pause");
	return 0;
}