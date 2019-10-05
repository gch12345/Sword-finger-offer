#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
int cmp(const void* num1, const void* num2){
	return *((char*)num1) - *((char*)num2);
}
char *** groupAnagrams(char ** strs, int strsSize, int* returnSize, int** returnColumnSizes){
	char ***re = (char***)malloc(strsSize * sizeof(char**));
	char **map = (char**)malloc(strsSize * sizeof(char*));
	char * p = (char*)calloc(25, sizeof(char));
	*returnColumnSizes = (int*)calloc(strsSize, sizeof(int));
	int size = 0;
	for (int i = 0; i < strsSize; i++){
		strcpy(p, strs[i]);
		qsort(p, strlen(p), sizeof(char), cmp);
		int k = 0;
		for (k = 0; k < size; k++){
			if (strcmp(p, map[k]) == 0){
				re[k][(*returnColumnSizes)[k]] = strs[i];
				((*returnColumnSizes)[k])++;
				break;
			}
		}
		if (k == size){
			map[size] = (char*)malloc(25 * sizeof(char));
			strcpy(map[size], p);
			re[size] = (char**)malloc(25 * sizeof(char*));
			re[size][0] = strs[i];
			((*returnColumnSizes)[size])++;
			size++;
		}
	}
	*returnSize = size;
	return re;
}
char *** groupAnagrams0(char ** strs, int strsSize, int* returnSize, int** returnColumnSizes){
	char ***re = (char***)malloc((strsSize + 1) * sizeof(char**));
	int *map = (int*)malloc((strsSize + 1) * sizeof(int));
	*returnColumnSizes = (int*)calloc((strsSize + 1), sizeof(int));
	int arr[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
		47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };
	int size = 0;
	for (int i = 0; i < strsSize; i++){
		char *p = strs[i];
		unsigned long long num = 1;
		while (*p != '\0'){
			num = num * arr[*p - 'a'];
			p++;
		}
		int k = 0;
		for (k = 0; k < size; k++){
			if (map[k] == num){
				re[k][(*returnColumnSizes)[k]] = strs[i];
				((*returnColumnSizes)[k])++;
				break;
			}
		}
		if (k == size){
			map[size] = num;
			re[size] = (char**)malloc((strsSize + 1) * sizeof(char*));
			re[size][0] = strs[i];
			((*returnColumnSizes)[size])++;
			size++;
		}
	}
	*returnSize = size;
	return re;
}