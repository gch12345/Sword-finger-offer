#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
//int main()
//{
//	int i = 0, n = 0;
//for (i = 100; i < 200; i++)
//{
//	int t = 0;
//	for (n = 2; n < i; n++)
//	{
//		if (i%n == 0){
//			t = 1;
//			break;
//		}
//	}
//	if(t == 0) printf("%d\t", i); 
//		
//}
//	system("pause");
//return 0;
//}
//int main()
//{
//	int i = 0, k = 0, h = 0;
//	for (i = 1; i <= 9; i++)
//	{
//		for (k = 1; k <= i; k++)
//		{
//			h = i*k;
//			printf("%d*%d=%-2d ",k, i ,h);
//		}
//		printf("\n");
//	}
//	system("pause");
//	return 0;
//}
//int main(){
//	int i = 0;
//	for (i = 1000; i <= 2000; i++)
//	{
//		if (((i % 4 == 0) && (i % 100 !=0)) ||( i % 400 == 0))
//			printf("%d\t", i);
//	}
//	return 0;
//}
//�����������α�����ֵ��������ֵ�����ݽ��н�����
//int main()
//{
//	int a = 0, b = 0, c = 0;
//	scanf("%d%d",&a,&b);
//	printf("a=%d b=%d\n", a, b);
//	c = a; a = b; b = c;
//	printf("a=%d b=%d\n", a, b);
//	system("pause");
//	return 0;
//}
//����������ʱ����������������������
//int main()
//{
//	int a = 0, b = 0;
//	scanf("%d%d", &a, &b);
//	printf("a=%d b=%d\n", a, b);
//	a = a^b;
//	b = a^b;
//	a = a^b;
//	printf("a=%d b=%d\n", a, b);
//	system("pause");
//	return 0;
//}
//��10 �����������ֵ
//int main()
//{
//	int a[10] = { 0 }, b = 0, i = 0, j = 0;
//	int MAX = a[0];
//	for (i = 0; i < 10; i++)
//	{
//		scanf("%d", &b);
//			a[i] = b;
//	}
//	for (j = 1; j<10; j++)
//	{
//		if (a[0]>a[j])
//			MAX = a[0];
//			else MAX = a[j];
//	}
//	printf("���ֵ��%d\n", MAX); 
//	system("pause");
//	return 0;
//}
//�����������Ӵ�С���
//int main()//��ð�����򷨣�
//{
//	int a[3] = { 0 }, i = 0,j = 0, b = 0;
//	for (i = 0; i < 3; i++)
//	{
//		scanf("%d",&a[i]);
//	}
//	for (j = 0; j < 3; j++)
//	{
//		for (i = 0; i<2 - j; i++){
//			if (a[i + 1]>a[i])
//			{
//				b = a[i];
//				a[i] = a[i + 1];
//				a[i + 1] = b;
//			}
//		}
//	}
//	for (i = 0; i < 3;i++)
//	printf("%d ", a[i]);
//	printf("\n");
//	system("pause");
//	return 0;
//}
//�������������Լ��
//int main()
//{
//	int a = 0, b = 0,c = 0,d = 0,i = 0 ;
//	scanf("%d%d", &a, &b);
//	if (a > b)
//		c = b,d = a;
//	else c = a,d = b;
//	for (i = c; i >= 1; i--)
//	{
//		if (d%i == 0 && c%i == 0){
//			printf("���Լ��Ϊ%d\n", i);
//			break;
//		}	
//	}	
//	system("pause"); 
//	return 0;
//}
//�������������Լ��(ŷ����ö���շת�ദ��)
//int main()
//{
//	int m = 0, n = 0, k = 0, h = 0;
//	scanf("%d%d", &m, &n);
//	if (m < n)
//		k = m,h = n;
//	else k = n,h = m;
//	while (k > 0)
//	{
//		int t = 0;
//		t = h;
//		h = k;
//		k = t%k;
//	}
//	printf("���Լ����%d\n", h);
//	system("pause");
//	return 0;
//}
//������a�е����ݺ�����b�е����ݽ��н�����
//int main()
//{
//	int a[5] = { 0 }, b[5] = { 0 }, i = 0,k = 0;
//		printf("a[5]");
//	for (i = 0; i < 5; i++)
//		scanf("%d", &a[i]);
//		printf("b[5]");
//	for (i = 0; i < 5; i++)
//		scanf("%d", &b[i]);
//	for (i = 0; i < 5; i++)
//	{
//		k = a[i];
//		a[i] = b[i];
//		b[i] = k;
//	}
//		printf("a[5]");
//	for (i = 0; i < 5; i++)
//		printf("%d ", a[i]);
//		printf("\n");
//		printf("b[5]");
//	for (i = 0; i < 5; i++)
//		printf("%d ", b[i]);
//	system("pause");
//	return 0;
//}
//����1/1-1/2+1/3-1/4+1/5 ���� + 1/99 - 1/100 ��ֵ��
//int main()
//{
//	float sum = 0.0; int i = 0;
//	for (i = 1; i <= 100; i++)
//	{
//		if (i%2==0)
//			i = -i;
//		sum = sum + 1.0/i;
//		if (i % 2 == 0)
//			i = -i;
//	}
//	printf("%f", sum);
//	system("pause");
//	return 0;
//}
//��д������һ�� 1�� 100 �����������г��ֶ��ٴ�����9��
//int main()
//{
//	int i = 0, j = 0;
//	for (i = 1; i <= 100; i++)
//	{
//		if (i % 10 == 9)
//			j++;
//		if (i / 10 == 9)
//			j++;
//	}
//	printf("�ܴ���%d\n", j);
//	system("pause");
//	return 0;
//}
//(���ֲ���)
//int main()
//{
//	int arr[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, left = 0, right = 0, k = 99;
//	right = sizeof(arr) / sizeof(arr[0]) - 1;
//	while (left <= right)
//	{
//		int h = left + (right-left) / 2;
//		if (arr[h] < k)
//		{
//			left = h + 1;
//		}
//		else if (arr[h]>k)
//		{
//			right = h - 1;
//		}
//		else{
//			printf("�ҵ���,�±���:%d\n",h );
//			break;
//		}
//	}
//	if (left > right)
//	{
//		printf("û���ҵ�\n");
//	}
//	system("pause");
//	return 0;
//}
//(����Ļ���������ͼ��)
//int main()
//{
//	char arr1[] = "                         ";
//	char arr2[] = "*************************";
//	char arr3[] = "                         ";
//	int i = strlen(arr1) / 2;
//	int left = i;
//	int right = i;
//	while (left >= 0)
//	{
//		arr1[left] = arr2[left];
//		arr1[right] = arr2[right];
//		printf("%s\n", arr1);
//		left--;
//		right++;
//	}
//	left++;
//	right--;
//	while (left != right)
//	{
//		arr1[left] = arr3[left];
//		arr1[right] = arr3[right];
//		printf("%s\n", arr1);
//		left++;
//		right--;
//	}
//
//	system("pause");
//	return 0;
//}
//�����0��999֮������С�ˮ�ɻ������������
//int main()
//{
//	int i=0, arr[3] = { 0 };
//	for (i = 0; i < 999; i++)
//	{
//		arr[0] = i / 100;
//		arr[1] = i % 100 / 10;
//		arr[2] = i % 10;
//		if (pow(arr[0], 3) + pow(arr[1], 3) + pow(arr[2], 3) == i)
//			printf("%d ", i);
//	}
//	system("pause");
//	return 0;
//}
//����Sn=a+aa+aaa+aaaa+aaaaa��ǰ5��֮�ͣ�����a��һ�����֣�
//int main()
//{
//	int i = 0, k = 0, sum = 0, sum1 = 0;
//  scanf("%d", &k);
//	for (i = 0; i < 5; i++)
//	{
//		sum = sum * 10 + k;
//		sum1 = sum1 + sum;
//	}
//	printf("%d\n", sum1);
//	system("pause");
//	return 0;
//}
//(���ֲ��ң���ϰ
//int main()
//{
//	int arr[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//	int i = 0;
//	int j = 10;
//	int left = 0;
//	int right = sizeof(arr) / sizeof(arr[0]) - 1;
//	while (left <= right)
//	{
//		i = (right - left) / 2 + left;
//		if (j > arr[i])
//		{
//			left = i + 1;
//		}
//		if (j < arr[i])
//		{
//			right = i - 1;
//		}
//		if (j == arr[i])
//		{
//			printf("�ҵ���,С����%d\n",i);
//			break;
//		}
//	}
//	if (left > right)
//	{
//		printf("û��\n");
//	}
//	system("pause");
//	return 0;
//}
//int main()
//{
//	int arr[5] = { 1, 99, 2, 3, 5 };
//	int i = 0;
//	int t = 0;
//	int j = 0;
//	for (j = 0; j < 5; j++)
//	{
//		for (i = 0; i < 4-j; i++)
//		{
//			if (arr[i]>arr[i + 1])
//			{
//				t = arr[i];
//				arr[i] = arr[i + 1];
//				arr[i + 1] = t;
//			}
//		}
//	}
//	for (i = 0; i < 5; i++)
//	{
//		printf("%d ", arr[i]);
//	}
//	system("pause");
//	return 0;
//}