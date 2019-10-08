#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdbool.h>
//给定一个非负整数数组，你最初位于数组的第一个位置。
//数组中的每个元素代表你在该位置可以跳跃的最大长度。
//判断你是否能够到达最后一个位置。
bool canJump(int* nums, int numsSize){
	if (numsSize == 1){
		return true;
	}
	for (int i = 0; i < numsSize;){
		if (nums[i] + i >= numsSize - 1){
			return true;
		}
		if (nums[i] == 0) {
			return false;
		}
		int maxJump = 0;
		int temp = 0;
		for (int j = i + 1; j < i + nums[i] + 1; j++){
			if (nums[j] + j > maxJump){
				maxJump = nums[j] + j;
				temp = j;
			}
		}
		i = temp;
	}
	return true;
}
