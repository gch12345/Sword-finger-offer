#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<string.h>
#include<math.h>
//int strStr(char * haystack, char * needle){
//	int len1 = strlen(haystack);
//	int len2 = strlen(needle);
//	if (len1 < len2)
//		return -1;
//	if (len2 == 0)
//		return 0;
//	int i = 0;
//	int j = 0;
//	for (i = 0; i < len1; i++){
//		if (haystack[i] != needle[0])
//			continue;
//		if ((len1 - i) < len2){
//			return -1;
//		}
//		for (j = 1; j < len2; j++){
//			if (haystack[i + j] != needle[j])
//				break;
//		}
//		if (j == len2)
//			return i;
//	}
//	return -1;
//}
//int main()
//{
//	for (int i = 0; i < 1000; i++) {
//		int num_add = 0;
//		int num = i;
//		while (num > 0) {
//			num_add += (int)pow(num % 10, 3);
//			num /= 10;
//		}
//		if (i == num_add)
//			printf("%d ", i);
//	}
//	//printf("%d", strStr("abcde", "cd"));
//	system("pause");
//	return 0;
//}
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
//(例如，数组[0, 1, 2, 4, 5, 6, 7] 可能变为[4, 5, 6, 7, 0, 1, 2])。
//
//搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 - 1 。
//
//你可以假设数组中不存在重复的元素。
//
//你的算法时间复杂度必须是 O(log n) 级别。
//int search(int* nums, int numsSize, int target){
//	int left = 0;
//	int right = numsSize - 1;
//	while (left <= right)
//	{
//		int mid = (left + right) / 2;
//		if (nums[mid] == target)
//		{
//			return mid;
//		}
//		if (nums[left] <= nums[mid])
//		{
//			if (target >= nums[left]&&target < nums[mid])
//			{
//				right = mid - 1;
//			}
//			else
//			{
//				left = mid + 1;
//			}
//		}
//		else
//		{
//			if (target > nums[mid] && target <= nums[right])
//			{
//				left = mid + 1;
//			}
//			else
//			{
//				right = mid - 1;
//			}
//		}
//	}
//	return -1;
//}
int cmp(const void *x1,const void* x2)
{
	return *(int*)x1 - *(int*)x2;
}
void nextPermutation(int* nums, int numsSize){
	int i = numsSize - 1;
	int min = nums[i];
	int j = 0;
	while (i > 0 && nums[i] <= nums[i - 1])
	{
		i--;
		j++;
	}
	int tmp = nums[i - 1];
	nums[i - 1] = min;
	nums[numsSize - 1] = tmp;
	if (j <= 1)
		return;
	qsort(nums + i, numsSize - i , sizeof(int), cmp);	
}
int main()
{
	int arr[] = { 1, 1 };
	nextPermutation(arr, sizeof(arr) / sizeof(arr[0]));
	return 0;
}