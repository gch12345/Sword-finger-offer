#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
//青蛙跳台阶问题
int jump(int k)
{
	if (k <= 2)
	{
		return k;
	}
	else
	{
		return jump(k - 1) + jump(k - 2);
	}
}
int jump1(int k)
{
	if (k <= 2)
	{
		return k;
	}
	else
	{
		return 2 * jump1(k - 1);
	}
}
int jump0(int k)
{
	int i = 0;
	int a = 1;
	int b = 2;
	int c = 0;
	if (k > 2)
	{
		for (i = 3; i <= k; i++)
		{
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
	else
		return k;
}
int main()
{
	int a = 0;
	scanf("%d", &a);
	printf("%d\n", jump(a));
	printf("%d\n", jump0(a));
	printf("%d\n", jump1(a));
	system("pause");
	return 0;
}