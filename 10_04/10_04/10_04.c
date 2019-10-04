#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//实现 pow(x, n) ，即计算 x 的 n 次幂函数
double myPow(double x, int n){
	if (n == 0)
		return 1;
	long long N = n;
	if (N < 0){
		N = -N;
		x = 1 / x;
	}
	double ret = 1;
	double count = x;
	for (long long i = N; i; i /= 2){
		if (i % 2 == 1){
			ret = ret * count;
		}
		count = count * count;
	}
	return ret;
}

double myPow(double x, int n){
	if (n == 0)
		return 1;
	if (n == 1)
		return x;
	if (n == -1)
		return 1 / x;
	double ret1 = myPow(x, n / 2);
	double ret2 = myPow(x, n % 2);
	double ret = ret1 * ret1 * ret2;
	return ret;
}