#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//����һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ�
//����������
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