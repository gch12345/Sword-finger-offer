#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<math.h>
#include<string.h>
char *fun(char **re,int n,int left,int right,int *returnSize){
	if (n == 0){
		(*returnSize)++;
		return;
	}
	if (left == right){
		re[*returnSize][left + right] = '(';
		fun(re, n - 1, left + 1, right, *returnSize);
	}
	else if (left > right){
		re[*returnSize][left + right] = ')';
		fun(re, n - 1, left, right + 1, *returnSize);
		returnSize++;
		strcpy(re[*returnSize], re[*returnSize] - 1);
	}
	else{
		return;
	}
}

char ** generateParenthesis(int n, int* returnSize){
	assert(returnSize != NULL);
	*returnSize = 0;
	char **re = (char**)malloc(sizeof(char*)*(int)pow(2, 2 * (n - 1)));
	for (int i = 0; i < (int)pow(2, 2 * (n - 1)); i++){
		re[i] = (char*)malloc(sizeof(char)*n * 2 + 1);
		re[i][0] = '(';
		re[i][n * 2 - 1] = ')';
		re[i][n * 2] = '\0';
	}
}
