#define _CRT_SECURE_NO_WARNINGS 1
#include<stdlib.h>
#include<stdio.h>
//����������һ���������У��������е�������˳����б������õ���һ��������ǰ�������£�
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
		//����һ����
		int count;
		char ch[10000] = { 0 };
		char *p = ch;
		//һֱ����
		while (*s != '\0')
		{
			count = 1;
			//���һֱ��ͬһ����
			while (*s == *(s + 1))
			{
				count++;
				s++;
			}
			//��һ��������
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