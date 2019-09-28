#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>
#include<string.h>
//给定一个字符串(s) 和一个字符模式(p) ，实现一个支持 '?' 和 '*' 的通配符匹配
bool isMatch(char * s, char * p){
	//if(strlen(s)<strlen(p))
	while (*p == '*' && *p == *(p + 1))
		p++;
	if (strcmp(p, "*") == 0)
		return true;
	if (*s == '\0'&&*p != '\0')
		return false;
	if (*s != '\0'&&*p == '\0')
		return false;
	if (*s == '\0'&&*p == '\0')
		return true;
	if (*s != *p && *p != '?'&& *p != '*')
		return false;
	if (*s == *p || *p == '?' || *p == '*')
	{
		if (isMatch(s + 1, p + 1) == true)
			return true;
	}
	if (*p == '*')
	{
		if (isMatch(s + 1, p) == true)
			return true;
	}
	if (*p == '*')
	{
		if (isMatch(s, p + 1) == true)
			return true;
	}
	return false;
}
bool isMatch(char * s, char * p){
	char *star = NULL;
	char *match = NULL; // 记录最后一次匹配的位置  + 1

	while (*s != '\0') {
		if (*s == *p || *p == '?') {
			s++;
			p++;
			continue;
		}

		if (*p == '*') {
			star = p++;
			match = s;
			continue;
		}

		// 如果失配了，回溯到 k + 1，即让 * 再多吞噬一个字符。
		if (star != NULL) {
			s = ++match;
			p = star + 1;
			continue;
		}
		return false;
	}

	while (*p != '\0' && *p == '*') ++p;

	return *s == *p;
}
bool isMatcha(char * s, char * p){
	int sLen = strlen(s);
	int pLen = strlen(p);
	int** sp = (int**)malloc(sLen + 1);
	for (int i = 0; i <= sLen; i++)
	{
		sp[i] = (int*)malloc(pLen + 1);
	}
	for (int i = 0; i <= sLen; i++)
	{
		for (int j = 0; j <= pLen; j++)
		{
			if (i == 0 && j == 0)
			{
				sp[i][j] = 1;
				continue;
			}
			else if (i == 0)
			{
				if (p[j - 1] == '*' && sp[i][j - 1] == 1)
					sp[i][j] = 1;
				else
					sp[i][j] = 0;
			}
			else if (j == 0)
			{
				sp[i][j] = 0;
			}
			else
			{
				if (s[i - 1] == p[j - 1] || p[j - 1] == '?')
					sp[i][j] = sp[i - 1][j - 1];
				else if (p[j - 1] == '*')
				{
					sp[i][j] = sp[i - 1][j] || sp[i][j - 1];
				}
				else
					sp[i][j] = 0;
			}
		}
	}
	if (sp[sLen][pLen] == 1)
		return true;
	else
		return false;
}

int main()
{
	char *s = "abc";
	char *p = "a*";
	printf("%s\n",isMatcha(s, p));
	system("pause");
	return 0;
}