#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<assert.h>
#include<stdlib.h>

//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
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
//给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
//
//不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
//
//元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素
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
//实现 strStr() 函数。
int strStr(char * haystack, char * needle){
	if (haystack == NULL)
		return -1;
	if (needle == NULL)
		return 0;

}

