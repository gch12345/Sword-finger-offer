#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>


/*
��һ�������ַ������ݸ������������Դ������¡������ҽ��� Z �������С�
���������ַ���Ϊ "LEETCODEISHIRING" ����Ϊ 3 ʱ���������£�
L   C   I   R
E T O E S I I G
E   D   H   N
֮����������Ҫ�����������ж�ȡ��������һ���µ��ַ��������磺"LCIRETOESIIGEDHN"��
   ��һ�к����һ�� ��� ������*2-2��
   ������  ��� ������*2-2*������2*������
*/
char * convert(char *s, int numRows)
{
	int len = 0;

	if (numRows <= 1)
		return s;
	char *q = s;
	while (*q != '\0')
	{
		len++;
		q++;
	}
	if (len <= numRows)
		return s;
	char* p = (char*)malloc(sizeof(char)*(len + 1));
	char* re = p;
	int i = 0;
	for (; i < numRows; i++)
	{
		if (i == 0 || i == numRows - 1)
		{
			int j = i;
			while (j < len)
			{
				*p = s[j];
				p++;
				j = j + 2 * numRows - 2;
			}
		}
		else
		{
			int j = i;
			*p = s[j];
			p++;
			j = j + 2 * numRows - 2 - 2 * i;
			while (j < len)
			{
				*p = s[j];
				p++;
				j = j + 2 * i;
				if (j >= len)
					break;
				*p = s[j];
				p++;
				j = j + 2 * numRows - 2 - 2 * i;
			}
		}
	}
	*p = '\0';
	return re;
}

int main()
{
	char s[] = "AB";
	printf("%s",convert(s, 1));
	system("pause");
	return 0;
}