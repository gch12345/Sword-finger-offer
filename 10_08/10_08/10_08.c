#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdbool.h>
//����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
//�����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
//�ж����Ƿ��ܹ��������һ��λ�á�
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
