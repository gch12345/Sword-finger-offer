#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>
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
