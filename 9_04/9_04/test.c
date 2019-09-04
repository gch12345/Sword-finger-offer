#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<stdbool.h>




#if 0
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//有效字符串需满足：
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
bool isValid(char * s){
	assert(s != NULL);
	char*p = s;
	int len = 0;
	while (*p++ != '\0')
		len++;
	if (len % 2 != 0){
		return 0;
	}
	int i = 0;
	int j = 0;
	if (len == 0)
		return 1;
	if (s[j] != '(' && s[j] != '{' && s[j] != '[')
		return 0;
	char *arr = (char*)malloc(sizeof(char)*len );
	for (; j < len; j++){
		if (s[j] == '(' || s[j] == '{' || s[j] == '['){
			arr[i] = s[j];
			i++;
		}
		else if (s[j] == ')'){
			if (arr[i - 1] == s[j] - 1){
				i--;
			}
			else{
				return 0;
			}
		}
		else{
			if (arr[i - 1] == s[j] - 2){
				i--;
			}
			else{
				return 0;
			}
		}
	}
	if (i == 0){
		return 1;
	}
	return 0;
}
int main()
{
	isValid("{}");
}
#endif