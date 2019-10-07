#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<math.h>
#include<stdlib.h>
#include<string.h>
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。


//void compose(char** re, char* digit, int* returnSize, char* container, int len){
//	if (*digit == '\0'){
//		re[*returnSize] = (char*)calloc(len + 1, sizeof(char));
//		strcpy(re[*returnSize], container - len);
//		(*returnSize)++;
//		return;
//	}
//	int num = *digit - '0' - 2;
//	for (int i = 0; i < 3; i++){
//		*container = 'a' + num * 3 + i;
//		compose(re, digit + 1, returnSize, container + 1, len);
//	}
//}
//char ** letterCombinations(char * digits, int* returnSize){
//	int len = strlen(digits);
//	char **re = (char**)malloc(sizeof(char*)* (int)pow(3, len));
//	char *container = (char*)calloc(len + 1, sizeof(char));
//	compose(re, digits, returnSize, container, len);
//	return re;
//}

void compose(char** re, char* digit, int* returnSize, char* container, int len){

	if (*digit == '\0'){
		re[*returnSize] = (char*)calloc((len + 1), sizeof(char));
		*container = '\0';
		strcpy(re[*returnSize], container - len);
		(*returnSize)++;
		return;
	}
	int num = *digit - '0' - 2;
	if (num < 5){
		for (int i = 0; i < 3; i++){
			*container = 'a' + num * 3 + i;
			compose(re, digit + 1, returnSize, container + 1, len);
		}
	}
	else if (num == 5){
		for (int i = 0; i < 4; i++){
			*container = 'p' + i;
			compose(re, digit + 1, returnSize, container + 1, len);
		}
	}
	else if (num == 6){
		for (int i = 0; i < 3; i++){
			*container = 't' + i;
			compose(re, digit + 1, returnSize, container + 1, len);
		}
	}
	else{
		for (int i = 0; i < 4; i++){
			*container = 'w' + i;
			compose(re, digit + 1, returnSize, container + 1, len);
		}
	}
}
char ** letterCombinations(char * digits, int* returnSize){
	*returnSize = 0;
	int len = strlen(digits);
	if (len == 0){
		char **re = (char**)malloc(sizeof(char*));
		return re;
	}
	int Num = 1;
	char *p = digits;
	for (int i = 0; i < len; i++){
		if (*p - '0' <= 6 || *p - '0' == 8)
			Num *= 3;
		else
			Num *= 4;
		p++;
	}
	char **re = (char**)malloc(sizeof(char*)* Num);
	char *container = (char*)malloc((len + 1) * sizeof(char));
	compose(re, digits, returnSize, container, len);
	return re;
}




int main()
{
	int returnSize = 0;
	char** re = letterCombinations("7", &returnSize);
	for (int i = 0; i < returnSize; i++){
		printf("%s\n", re[i]);
	}
	system("pause");
	return 0;
}