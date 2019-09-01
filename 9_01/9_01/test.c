#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<assert.h>
#include<stdlib.h>
//编写一个函数来查找字符串数组中的最长公共前缀。
//如果不存在公共前缀，返回空字符串 ""。
char * longestCommonPrefix(char ** strs, int strsSize){
	if (strsSize == 0)
		return "";
	else if (strsSize == 1)
		return *strs;
	int i = 0;
	for (; i < strsSize - 1; i++)
	{
		int j = 0;
		while (strs[0][j] == strs[i + 1][j] && strs[i + 1][j] != '\0')
		{
			j++;
		}
		strs[0][j] = '\0';
		if (strs[0][0] == '\0')
			break;
	}
	return strs[0];
}
int main()
{
	char str1[] = "a";
	char str2[] = "aca";
	char str3[] = "accb";
	char str4[] = "b";
	char *p[4] = { str1, str2, str3, str4 };
	printf("%s",longestCommonPrefix(p, 4));
	system("pause");
	return 0;
}
