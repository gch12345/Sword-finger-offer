#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//1.num1 和 num2 的长度小于110。
//2.num1 和 num2 只包含数字 0 - 9。
//3.num1 和 num2 均不以零开头，除非是数字 0 本身。
//4.不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

char * multiply(char * num1, char * num2){
	if (strcmp(num1, "0") == 0 || strcmp(num2, "0") == 0)
	{
		char *re = (char*)malloc(2);
		re[0] = '0';
		re[1] = '\0';
		return re;
	}
	char * re = (char*)calloc(250, sizeof(char));
	int end = 248;
	int len1 = strlen(num1);
	int len2 = strlen(num2);
	while (len2 != 0)
	{
		int carry = 0;
		for (int i = len1; i > 0; i--)
		{
			if (re[end - len1 + i] == 0)
			{
				re[end - len1 + i] = ((num1[i - 1] - '0')*(num2[len2 - 1] - '0') + carry) % 10 + '0';
				if ((num1[i - 1] - '0')*(num2[len2 - 1] - '0') + carry >= 10)
					carry = ((num1[i - 1] - '0')*(num2[len2 - 1] - '0') + carry) / 10;
				else
					carry = 0;
			}
			else
			{
				int tmp = re[end - len1 + i] - '0' + ((num1[i - 1] - '0')*(num2[len2 - 1] - '0') + carry);
				re[end - len1 + i] = (tmp) % 10 +'0';
				if (tmp >= 10)
					carry = tmp / 10;
				else
					carry = 0;
			}
		}
		if (carry != 0)
		{
			re[end - len1] = carry + '0';
		}
		end--;
		len2--;
	}
	while (*re == '\0')
		re++;
	return re;
}

int charToInt(char*ch)
{
	int re = 0;
	while (*ch != '\0')
	{
		re = re * 10 + *ch - '0';
		ch++;
	}
	return re;
}

char * multiply0(char * num1, char * num2){
	int Num1 = charToInt(num1);
	int Num2 = charToInt(num2);
	int num = Num1 * Num2;
	if (num == 0)
	{
		char* re = (char*)malloc(2);
		re[0] = '0';
		re[1] = 0;
		return re;
	}
	int i = 0;
	int num0 = num;
	while (num0 != 0)
	{
		i++;
		num0 /= 10;
	}
	char* re = (char*)malloc(i + 1);
	re[i] = 0;
	while (num != 0)
	{
		re[i - 1] = num % 10 + '0';
		i--;
		num /= 10;
	}
	return re;
}
int main()
{
	char*re = multiply("913", "25");
	printf("%s\n", re);
	system("pause");
	return 0;
}