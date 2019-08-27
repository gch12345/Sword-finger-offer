#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>


/*
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
   第一行和最后一行 间隔 总行数*2-2。
   其他行  间隔 总行数*2-2*行数；2*行数。
*/
char * convert(char *s, int numRows)
{
	int len = 0;

	if (numRows <= 1)
		return s;
	char *q = s;
	while (*q != '\0')
	{
		len++;
		q++;
	}
	if (len <= numRows)
		return s;
	char* p = (char*)malloc(sizeof(char)*(len + 1));
	char* re = p;
	int i = 0;
	for (; i < numRows; i++)
	{
		if (i == 0 || i == numRows - 1)
		{
			int j = i;
			while (j < len)
			{
				*p = s[j];
				p++;
				j = j + 2 * numRows - 2;
			}
		}
		else
		{
			int j = i;
			*p = s[j];
			p++;
			j = j + 2 * numRows - 2 - 2 * i;
			while (j < len)
			{
				*p = s[j];
				p++;
				j = j + 2 * i;
				if (j >= len)
					break;
				*p = s[j];
				p++;
				j = j + 2 * numRows - 2 - 2 * i;
			}
		}
	}
	*p = '\0';
	return re;
}

int main()
{
	char s[] = "AB";
	printf("%s",convert(s, 1));
	system("pause");
	return 0;
}