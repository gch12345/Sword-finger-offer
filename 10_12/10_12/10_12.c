#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//����һ����������Сд��ĸ�Ϳո� ' ' ���ַ��������������һ�����ʵĳ��ȡ�
//������������һ�����ʣ��뷵�� 0 ��
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

//����һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
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