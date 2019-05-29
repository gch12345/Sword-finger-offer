#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
//请实现一个函数，
//将一个字符串中的每个空格替换成“ % 20”。
//例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
void replace(char *arr, int sz)
{
	int i = 0;
	int j = 0;
	int count = 0;
	for (i = sz - 1; i >= 0; i--)
	{
		if (arr[i] == ' ')
			count++;
	}
	for (i = sz - count * 2 - 2; i >= 0; i--)
	{
		if (arr[i] != ' ')
		{
			arr[i + count * 2] = arr[i];
		}
		else
		{
			count--;
			arr[i + count * 2] = '%';
			arr[i + count * 2 + 1] = '2';
			arr[i + count * 2 + 2] = '0';
		}
	}
}
int main()
{
	char arr[20] = {"We Are Happy"};
	int i = 0;
	int sz = sizeof(arr) / sizeof(arr[0]);
	replace(arr, sz);
	printf("%s\n", arr);
	system("pause");
	return 0;
}