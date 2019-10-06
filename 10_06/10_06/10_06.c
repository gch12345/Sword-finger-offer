#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<math.h>
#include<stdlib.h>
#include<string.h>

void compose(char** re, char* digit, int* returnSize, char* container, int len){
	if (*digit == '\0'){
		re[*returnSize] = (char*)calloc(len + 1, sizeof(char));
		strcpy(re[*returnSize], container - len);
		(*returnSize)++;
		return;
	}
	int num = *digit - '0' - 2;
	for (int i = 0; i < 3; i++){
		*container = 'a' + num * 3 + i;
		compose(re, digit + 1, returnSize, container + 1, len);
	}
}
char ** letterCombinations(char * digits, int* returnSize){
	int len = strlen(digits);
	char **re = (char**)malloc(sizeof(char*)* (int)pow(3, len));
	char *container = (char*)calloc(len + 1, sizeof(char));
	compose(re, digits, returnSize, container, len);
	return re;
}
int main()
{
	int returnSize = 0;
	char** re = letterCombinations("23", &returnSize);
	for (int i = 0; i < returnSize; i++){
		printf("%s\n", re[i]);
	}
	system("pause");
	return 0;
}