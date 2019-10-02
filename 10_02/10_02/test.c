#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//给定一个 n × n 的二维矩阵表示一个图像。
//将图像顺时针旋转 90 度。
//说明：
//你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。


void rotate(int** matrix, int matrixSize, int* matrixColSize){
	int n = *matrixColSize;
	for (int i = 0; i < (n + 1) / 2; i++) {
		for (int j = 0; j < n / 2; j++) {
			int temp = matrix[n - 1 - j][i];
			matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
			matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
			matrix[j][n - 1 - i] = matrix[i][j];
			matrix[i][j] = temp;
		}
	}
}

void rotate(int** matrix, int matrixSize, int* matrixColSize){
	for (int i = 0; i < *matrixColSize; i++){
		for (int j = i + 1; j < *matrixColSize; j++){
			int tmp = matrix[i][j];
			matrix[i][j] = matrix[j][i];
			matrix[j][i] = tmp;
		}
	}
	for (int i = 0; i < *matrixColSize; i++){
		for (int j = 0; j < *matrixColSize / 2; j++){
			int tmp = matrix[i][j];
			matrix[i][j] = matrix[i][*matrixColSize - j - 1];
			matrix[i][*matrixColSize - j - 1] = tmp;
		}
	}
}
