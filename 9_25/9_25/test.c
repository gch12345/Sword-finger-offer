#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>
//����һ���ַ���(s) ��һ���ַ�ģʽ(p) ��ʵ��һ��֧�� '?' �� '*' ��ͨ���ƥ��
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
