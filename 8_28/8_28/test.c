#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
//请你来实现一个 atoi 函数，使其能将字符串转换成整数。
int myAtoi(char * str){
	assert(str != NULL);
	long long int re = 0;
	while (*str == ' ')
	{
		str++;
	}
	int sign = 0;
	if (sign == 0 && *str == '-')
	{
		sign = -1;
		str++;
	}
	else if (sign == 0 && *str == '+')
	{
		sign = 1;
		str++;
	}
	int i = 0;
	while (*str >= '0'&&*str <= '9')
	{
		re = re * 10 + (*str - '0');

		if (re>INT_MAX)
		{
			if (sign != -1)
				return INT_MAX;
			else
				return INT_MIN;
		}
		str++;
	}
	if (sign == -1)
	{
		re = re*sign;
		sign = 1;
	}

	return (int)re;
}

int main()
{
	char *str = "2147483800";
	printf("%d\n", myAtoi(str));
	system("pause");
	return 0;
}



//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
//请根据这个假设，如果反转后整数溢出那么就返回 0。
#if 0
int reverse(int x){
	long long re = 0;
	while (x != 0)
	{
		re = re * 10 + x % 10;
		x /= 10;
	}
	if (re != (int)re)
		return 0;
	return re;
}

int main()
{
	int i = INT_MAX;
	//int j = -11;
	//printf("%d\n", j % 10);
	printf("%d\n", reverse(i));
	system("pause");
	return 0;
}
#endif