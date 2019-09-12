#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
//����һ��ֻ���� '(' �� ')' ���ַ������ҳ���İ�����Ч���ŵ��Ӵ��ĳ��ȡ�
int longestValidParentheses(char * s){
	assert(s != NULL);
	int reLeft = 0;
	int reRight = 0;
	int re = 0;
	char *p = s;
	while (*s != '\0')
	{
		while (*s == '(')
		{
			reLeft++;
			s++;
		}
		while (reLeft > reRight&&*s == ')')
		{
			reRight++;
			s++;
		}
		if (reLeft == reRight)
		{
			if (re < 2 * reRight)
				re = 2 * reRight;
		}
		if (*s == ')'&&reLeft == reRight)
		{
			if (re < 2 * reLeft)
				re = 2 * reLeft;
			reLeft = 0;
			reRight = 0;
			s++;
		}
	}
	if (reLeft > reRight)
	{
		reRight = 0;
		reLeft = 0;
		s--;
		while (s >= p)
		{
			while (*s == ')')
			{
				reRight++;
				if (s == p)
					break;
				s--;
			}
			while (*s == '('&&reLeft < reRight)
			{
				reLeft++;
				if (s == p)
					break;
				s--;
			}
			if (reLeft == reRight)
			{
				if (re < 2 * reRight)
					re = 2 * reRight;
			}
			if (*s == '('&&reLeft == reRight)
			{
				if (re < 2 * reLeft)
					re = 2 * reLeft;
				reLeft = 0;
				reRight = 0;
				if (s == p)
					return re;
				s--;
			}
			if (s == p)
				break;
		}
	}
	return re;
}
int main()
{
	char *s = "()(()";
	longestValidParentheses(s);
	system("pause");
	return 0;
}