#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>


#if 0
//由短板决定
//若向内移动短板，水槽的短板  可能变大，因此水槽面积  可能增大。
//若向内移动长板，水槽的短板  不变或变小，下个水槽的面积一定小于当前水槽面积。
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