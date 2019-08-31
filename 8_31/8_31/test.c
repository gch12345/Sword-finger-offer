#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>

int romanToInt(char * s){
	assert(s != NULL);
	int re = 0;
	while (*s != '\0')
	{
		switch (*s)
		{
		case 'M':
			re = re + 1000;
			break;
		case 'D':
			re = re + 500;
			break;
		case 'C':
			if (*(s + 1) == 'D' || *(s + 1) == 'M')
				re = re - 100;
			else
				re = re + 100;
			break;
		case 'L':
			re = re + 50;
			break;
		case 'X':
			if (*(s + 1) == 'L' || *(s + 1) == 'C')
				re = re - 10;
			else
				re = re + 10;
			break;
		case 'V':
			re = re + 5;
			break;
		case 'I':
			if (*(s + 1) == 'V'||*(s + 1) == 'X')
				re = re - 1;
			else
				re = re + 1;
			break;
		default:
			break;
		}
		s++;
	}
	return re;
}

int main()
{
	char *str = "IV";
	printf("%d\n",romanToInt(str));
	system("pause");
	return 0;
}
