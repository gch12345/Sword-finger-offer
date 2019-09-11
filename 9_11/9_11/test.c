#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<string.h>
int strStr(char * haystack, char * needle){
	int len1 = strlen(haystack);
	int len2 = strlen(needle);
	if (len1 < len2)
		return -1;
	if (len2 == 0)
		return 0;
	int i = 0;
	int j = 0;
	for (i = 0; i < len1; i++){
		if (haystack[i] != needle[0])
			continue;
		if ((len1 - i) < len2){
			return -1;
		}
		for (j = 1; j < len2; j++){
			if (haystack[i + j] != needle[j])
				break;
		}
		if (j == len2)
			return i;
	}
	return -1;
}
int main()
{
	printf("%d", strStr("abcde", "cd"));
	system("pause");
	return 0;
}