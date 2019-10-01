#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//给定一个可包含重复数字的序列，返回所有不重复的全排列
void swap(int *a, int* b){
	int temp = *a;
	*a = *b;
	*b = temp;
}

int cmp(void* a, void* b){
	return *(int*)a - *(int*)b;
}

void backtrack(int* nums, int numsSize, int** re, int frist, int*returnSize, int** returnColumnSizes){
	if (frist == numsSize){
		returnColumnSizes[0][*returnSize] = numsSize;
		re[*returnSize] = (int*)malloc(numsSize * sizeof(int));
		memcpy(re[*returnSize], nums, numsSize * sizeof(int));
		(*returnSize)++;
		return;
	}
	for (int i = frist; i < numsSize; i++){
		if (i != frist && nums[i] == nums[i - 1])
			continue;
		swap(&(nums[i]), &(nums[frist]));
		qsort(nums + frist + 1, numsSize - frist - 1, sizeof(int), cmp);
		backtrack(nums, numsSize, re, frist + 1, returnSize, returnColumnSizes);
		swap(&(nums[i]), &(nums[frist]));
		qsort(nums + frist, numsSize - frist, sizeof(int), cmp);
	}
}

int** permuteUnique(int* nums, int numsSize, int* returnSize, int** returnColumnSizes){
	int len = 1;
	for (int i = 1; i <= numsSize; i++){
		len *= i;
	}
	int** re = (int*)malloc(sizeof(int*)* len);
	returnColumnSizes[0] = (int*)malloc(len * sizeof(int));
	*returnSize = 0;
	qsort(nums, numsSize, sizeof(int), cmp);
	backtrack(nums, numsSize, re, 0, returnSize, returnColumnSizes);
	return re;
}
