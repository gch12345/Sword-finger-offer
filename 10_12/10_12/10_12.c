#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
//如果不存在最后一个单词，请返回 0 。
int lengthOfLastWord(char * s){
	int len = strlen(s);
	if (len == 0)
		return 0;
	while ((s + len - 1) != s && *(s + len - 1) == ' '){
		len--;
	}
	int re = 0;
	while ((s + len - 1) != s && *(s + len - 1) != ' '){
		re++;
		len--;
	}
	if ((s + len - 1) == s && *s != ' ')
		re++;
	return re;
}

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
int maxSubArray(int* nums, int numsSize){
	if (numsSize == 1){
		return nums[0];
	}
	int max = nums[0];
	int num = nums[0];
	for (int i = 1; i < numsSize; i++){
		if (num < 0){
			num = nums[i];
		}
		else{
			num += nums[i];
		}
		if (num > max){
			max = num;
		}
	}
	return max;
}