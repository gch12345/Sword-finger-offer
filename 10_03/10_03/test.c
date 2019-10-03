#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素）
//返回其最大和
int maxSubArray(int* nums, int numsSize){
	int max = nums[0];
	int sum = nums[0];
	for (int i = 1; i <numsSize; i++){
		if (sum <= 0){
			if (sum > max){
				max = sum;
			}
			sum = 0;
		}
		sum += nums[i];
		if (sum > max){
			max = sum;
		}
	}
	return max;
}
int maxSubArray0(int* nums, int numsSize){
	int max = nums[0];
	int tmp = nums[0];
	for (int i = 1; i < numsSize; i++){
		tmp += nums[i];
		if (tmp < nums[i]){
			tmp = nums[i];
		}
		if (tmp > max){
			max = tmp;
		}
	}
	return max;
}