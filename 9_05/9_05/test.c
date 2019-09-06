#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<math.h>
#include<string.h>
void fun(int n, char **re, int left, int right, int *returnSize, char *map){
	if (left == n && right == n){
		re[*returnSize] = (char*)calloc(n * 2 + 1, sizeof(char));
		strcat(re[*returnSize], map);
		(*returnSize)++;
		return;
	}
	if (left > right){
		map[left + right] = ')';
		fun(n, re, left, right + 1, returnSize, map);
	}
	if (left < n){
		map[left + right] = '(';
		fun(n, re, left + 1, right, returnSize, map);
	}
}

char ** generateParenthesis(int n, int* returnSize){
	assert(returnSize != NULL);
	*returnSize = 0;
	char **re = (char**)malloc(sizeof(char*)*(int)pow(2, 2 * n));
	char*map = (char*)calloc(n * 2 + 1, sizeof(char));
	fun(n, re, 0, 0, returnSize, map);
	return re;
}
int main()
{
	int returnSize = 0;
	generateParenthesis(3, &returnSize);
	system("pause");
	return 0;
}