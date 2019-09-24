#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
//给定一个非负整数数组，你最初位于数组的第一个位置。
//
//数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//假设你总是可以到达数组的最后一个位置。
int jump0(int* nums, int numsSize){
	int count = 0;
	int num = numsSize - 2;
	int tmp = 0;
	for (int i = num; i >= 0; i = num)
	{
		for (int j = num; j >= 0; j--)
		{
			if (nums[j] >= num + 1 - j)
			{
				tmp = j;
			}
		}
		num = tmp - 1;
		count++;
	}
	return count;
}
int jump(int* nums, int numsSize)
{
	int i, j;
	int maxPosition;
	int tmp;
	int max;
	int step = 0;

	if (numsSize == 0) return 0;
	if (numsSize == 1) return 0;

	for (i = 0; i < numsSize;) {
		if ((i + nums[i]) >= (numsSize - 1)) {
			return step + 1;
		}
		if (nums[i] == 0) {
			return 0;
		}
		max = 0;
		for (j = i + 1; j < i + 1 + nums[i]; j++) {
			tmp = j + nums[j];
			if (max < tmp) {
				max = tmp;
				maxPosition = j;
			}
		}
		step++;
		i = maxPosition;
	}

	return step;
}
int main()
{
	int arr[] = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
	int re = jump(arr, sizeof(arr) / sizeof(arr[0]));
	printf("%d\n", re);
	system("pause");
	return 0;
}