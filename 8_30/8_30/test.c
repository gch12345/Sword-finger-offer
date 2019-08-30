#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
//����һ������������תΪ�������֡�����ȷ���� 1 �� 3999 �ķ�Χ��
char * One_intToRoman(int num, char type[3], char*N)
{
	int count = 0;
	if (num == 9)
	{
		N[count] = type[2];
		count++;
		N[count] = type[0];
		count++;
		return N;
	}
	if (num >= 5)
	{
		N[count] = type[1];
		count++;
		num = num % 5;
	}
	if (num == 4)
	{
		N[count] = type[2];
		count++;
		N[count] = type[1];
		count++;
	}
	else
	{
		while (num--)
		{
			N[count] = type[2];
			count++;
		}
	}
	return N;
}
char * intToRoman(int num){
	char *str_Rnman=(char*)malloc(17);
	memset(str_Rnman, 0, 17);
	char str1[3] = { 'X', 'V', 'I' };
	char str2[3] = { 'C', 'L', 'X' };
	char str3[3] = { 'M', 'D', 'C' };
	char str4[3] = { 'M', 'M', 'M' };
	char*p[4] = { str1, str2, str3 ,str4};
	int count = 0;
	int num0 = num;
	while (num0>0)
	{
		num0 /= 10;
		count++;
	}
	int Num = 0;
	while (count > 0)
	{
		count--;
		Num = (num - num % (int)pow(10, count)) / (int)pow(10, count);
		num = num % (int)pow(10, count);
		char str1[5] = { 0 };
		strcat(str_Rnman, One_intToRoman(Num, p[count], str1));
	}
	return str_Rnman;
}

int main()
{
	printf("%s\n",intToRoman(1994));
	system("pause");
	return 0;
}