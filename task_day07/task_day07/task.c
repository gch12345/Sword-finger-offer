#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
//�ݹ�ʵ�����n��쳲�������
//int Fibonacci_number(int k)
//{
//	if (k <= 2)
//		return 1;
//	else
//		return Fibonacci_number(k - 1) + Fibonacci_number(k - 2);
//}
//int main()
//{
//	int a = 0;
//	scanf("%d", &a);
//	printf("%d\n", Fibonacci_number(a));
//	system("pause");
//	return 0;
//}
//�ǵݹ�ʵ�����n��쳲�������
//int  Fibonacci_number(int k)
//{
//	int a = 1;
//	int b = 1;
//	int c = 1;
//	while (k>2)
//	{
//		c = a + b;
//		a = b;
//		b = c;
//		k--;
//	}
//	return c;
//}
//int main()
//{
//	int a = 0;
//	scanf("%d", &a);
//	printf("%d\n", Fibonacci_number(a));
//	system("pause");
//	return 0;
//}
//��дһ������ʵ��n^k��ʹ�õݹ�ʵ��
//int index(int n,int k)
//{
//	if (k == 1)
//		return n;
//	else 
//	    return n*index(n, k - 1);
//}
//int main()
//{
//	int n = 0;
//	int k = 0;
//	scanf("%d%d", &n, &k);
//	printf("%d\n", index(n,k));
//	system("pause");
//	return 0;
//}
//дһ���ݹ麯��DigitSum(n)������һ���Ǹ����������������������֮��
//int sum = 0;
//int DigitSum(unsigned int k)
//{
//	if (k < 10)
//		return k;
//	else
//		return sum = DigitSum(k / 10) + k % 10;
//}
//int main()
//{
//	unsigned int a = 0;
//	scanf("%d", &a);
//	printf("%d\n", DigitSum(a));
//	system("pause");
//	return 0;
//}
//��дһ������ reverse_string(char * string)���ݹ�ʵ�֣�
//ʵ�֣��������ַ����е��ַ��������С�
//Ҫ�󣺲���ʹ��C�������е��ַ�������������
//char arr0[] = { 0 };
//int i = -1;
//char reverse_string(char * string)
//{
//	if (*string == '\0')
//	{
//		return 0 ;
//	}
//	else
//	{
//		reverse_string(string + 1);
//		return arr0[++i] = *string;
//	}
//}
//int main()
//{
//	char arr[] = { "abcd" };
//	reverse_string(arr);
//	printf("%s\n", arr0);
//	system("pause");
//	return 0;
//}
//�ݹ�ʵ��strlen
//int My_strle(char* arr)
//{
//	if (*arr == '\0')
//		return 0;
//	else
//		return 1 + My_strle(arr + 1);
//}
//int main()
//{
//	char arr[] = { "abcde" };
//	printf("%d\n", My_strle(arr));
//	system("pause");
//	return 0;
//}
//�ǵݹ�ʵ��strlen
//int My_strle(char*arr)
//{
//	int sum = 0;
//	int i = 0;
//	while (1)
//	{
//		if (*arr == '\0')
//			break;
//		else
//		{
//			sum++;
//			arr++;
//		}
//	}
//	return sum;
//}
//int main()
//{
//	char arr[] = { "abcde" };
//	printf("%d\n", My_strle(arr));
//	system("pause");
//	return 0;
//}
//�ݹ�ʵ����n�Ľ׳�
//int Factorial(int k)
//{
//	if (k == 1)
//		return 1;
//	else
//		return k*Factorial(k - 1);
//}
//int main()
//{
//	int a = 0;
//	scanf("%d", &a);
//	printf("%d\n", Factorial(a));
//	system("pause");
//	return 0;
//}
//�ǵݹ�ʵ����n�Ľ׳�
//int Factorial(int k)
//{
//	int i = 0;
//	int sum = 1;
//	for (i = 1; i <= k; i++)
//	{
//		sum = sum*i;
//	}
//	return sum;
//}
//int main()
//{
//	int a = 0;
//	scanf("%d", &a);
//	printf("%d", Factorial(a));
//	system("pause");
//	return 0;
//}
//�ݹ鷽ʽʵ�ִ�ӡһ��������ÿһλ 
//void Printf(int k)
//{
//	if (k > 9)
//	{
//		Printf(k/10);
//	}
//	printf("%d ", k % 10);
//}
//int main()
//{
//	int a = 0;
//	scanf("%d", &a);
//	Printf(a);
//	system("pause");
//	return 0;
//}