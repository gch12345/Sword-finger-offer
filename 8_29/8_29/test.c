#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>


#if 0
//�ɶ̰����
//�������ƶ��̰壬ˮ�۵Ķ̰�  ���ܱ�����ˮ�����  ��������
//�������ƶ����壬ˮ�۵Ķ̰�  ������С���¸�ˮ�۵����һ��С�ڵ�ǰˮ�������
int maxArea(int* height, int heightSize){
	assert(height != NULL);
	int re = 0;
	int sum = 0;
	int *pLeft = height;
	int *pRight = height + heightSize - 1;
	while (pLeft != pRight)
	{
		if (*pLeft <= *pRight)
		{
			sum = *pLeft*(pRight - pLeft);
			pLeft++;
		}
		else
		{
			sum = *pRight*(pRight - pLeft);
			pRight--;
		}
		if (re < sum)
		{
			re = sum;
		}
	}
	return re;
}

int main()
{
	int arr[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
	printf("%d\n",maxArea(arr, sizeof(arr) / sizeof(arr[0])));
	system("pause");
	return 0;
}
#endif