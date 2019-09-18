#define _CRT_SECURE_NO_WARNINGS 1
#include<stdlib.h>
#include<stdio.h>
//报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
//
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
char *countHelper(char *s, int n)
{
	if (n == 1)
		return s;
	else
	{
		//求下一个数
		int count;
		char ch[10000] = { 0 };
		char *p = ch;
		//一直读数
		while (*s != '\0')
		{
			count = 1;
			//如果一直是同一个数
			while (*s == *(s + 1))
			{
				count++;
				s++;
			}
			//下一个数更新
			*p++ = (char)(count + '0');
			*p++ = *s++;
		}
		return countHelper(ch, n - 1);
	}
}

char *countAndSay1(int n)
{
	return countHelper("1", n);
}
char str1[2000] = { 0 };
char str2[2000] = { 0 };
char *countAndSay(int n)
{
	if (n == 1)
	{
		return "1";
	}
	else
	{
		str1[0] = '1';
	}
	char*p = str1;
	char*q = str2;
	for (int i = 1; i < n; i++)
	{
		while (*p != '\0')
		{
			int count = 1;
			while (*p == *(p + 1))
			{
				count++;
				p++;
			}
			*q++ = count + '0';
			*q++ = *p++;
		}
		if (i % 2 == 1)
		{
			p = str2;
			q = str1;
		}
		else
		{
			q = str2;
			p = str1;
		}
	}
	if (p == str1)
		return str1;
	else
		return str2;
}
int main()
{
	printf("%s", countAndSay(10));
	system("pause");
	return 0;
}