#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<assert.h>
#include<stdlib.h>

//����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
//��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
int removeDuplicates_6(int* nums, int numsSize)
{
	int j = 0;
	if (numsSize <= 1)
		return numsSize;
	for (int i = 1; i<numsSize; i++)
	{
		if (nums[j] != nums[i])
		{
			nums[++j] = nums[i];
		}
	}

	return j + 1;
}

int removeDuplicates(int* nums, int numsSize){
	assert(nums != NULL);
	if (numsSize <= 1){
		return numsSize;
	}
	int *p = nums;
	int *q = nums + 1;
	int i = 0;
	int re = 1;
	for (i = 0; i < numsSize - 1; i++){
		if (*p == *q){
			q++;
		}
		else{
			p++;
			*p = *q;
			q++;
			re++;
		}
	}
	return re;
}

//int main()
//{
//	int arr[] = { 1, 1, 2, 2, 3, 4, 4, 5, 5, 6 };
//	int re = removeDuplicates(arr, sizeof(arr) / sizeof(arr[0]));
//	for (int i = 0; i < re; i++){
//		printf("%d ", arr[i]);
//	}
//	system("pause");
//	return 0;
//}
//����һ������ nums ��һ��ֵ val������Ҫԭ���Ƴ�������ֵ���� val ��Ԫ�أ������Ƴ���������³��ȡ�
//
//��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
//
//Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ��
int removeElement(int* nums, int numsSize, int val){
	assert(nums != NULL);
	if (numsSize <= 1){
		return numsSize;
	}
	int j = 0;
	for (int i = 0; i < numsSize; i++){
		if (nums[i] != val){
			nums[j++] = nums[i];
		}
	}
	return j;
}
int main()
{
	int arr[] = { 1, 2, 3, 4, 4, 2, 2, 3, 2 };
	int re = removeElement(arr, sizeof(arr) / sizeof(arr[0]), 2);
	for (int i = 0; i < re; i++){
		printf("%d ", arr[i]);
	}
	system("pause");
	return 0;
}
//ʵ�� strStr() ������
int strStr(char * haystack, char * needle){
	if (haystack == NULL)
		return -1;
	if (needle == NULL)
		return 0;

}

