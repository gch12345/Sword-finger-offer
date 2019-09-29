#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//给定一个没有重复数字的序列，返回其所有可能的全排列。
void swap(int* nums, int a, int b) {
	int temp = nums[a];
	nums[a] = nums[b];
	nums[b] = temp;
}
void  backtrack(int* nums, int numsSize, int** ret, int first, int* returnSize, int** returnColumnSizes) {
	if (first == numsSize) {
		returnColumnSizes[0][*returnSize] = numsSize;
		ret[*returnSize] = (int*)calloc(numsSize, sizeof(int));
		memcpy(ret[*returnSize], nums, numsSize*sizeof(int));
		(*returnSize)++;
		return;
	}
	int  i;
	for (i = first; i<numsSize; i++) {
		swap(nums, first, i);
		backtrack(nums, numsSize, ret, first + 1, returnSize, returnColumnSizes);
		swap(nums, first, i);
	}
}
int** permute(int* nums, int numsSize, int* returnSize, int** returnColumnSizes) {
	int** ret = (int **)calloc(720, sizeof(int *));
	returnColumnSizes[0] = (int*)calloc(720, sizeof(int));
	*returnSize = 0;
	backtrack(nums, numsSize, ret, 0, returnSize, returnColumnSizes);
	return ret;
}
