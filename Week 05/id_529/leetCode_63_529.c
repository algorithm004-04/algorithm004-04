#include <stdlib.h>
#include <stdio.h>
int uniquePathsWithObstacles(int** obstacleGrid, int obstacleGridSize, int* obstacleGridColSize)
{
    int i;
    int j;
    int arry[100][100] = {0};
    for (i = 0; i < *obstacleGridColSize; i++) {
        if (obstacleGrid[0][i] = 1) {
            for(j = i; j < *obstacleGridColSize; j++) {
                arry[0][j] = 0;
            }
        } else {
            arry[0][i] = 1;
        }
    }
    for (i = 0; i < obstacleGridSize; i++) {
        if (obstacleGrid[i][0] = 1) {
            for(j = i; j < obstacleGridSize; j++) {
                arry[i][0] = 0;
            }
        } else {
            arry[i][0] = 1;
        }
    }   

    for (i = 1; i < *obstacleGridColSize; i++) {
        for (j = 1; j < obstacleGridSize; j++) {
            if (obstacleGrid[i][j-1] == 0) {
                arry[i][j] += arry[i][j-1];
            }

            if (obstacleGrid[i-1][j] == 0) {
                arry[i][j] += arry[i-1][j];
            }
        }
    }
    return arry[*obstacleGridColSize][obstacleGridSize];   
}

void main()
{
    int m = 3; 
    int n = 3;
    int sum;
    int a[3][3] = {{0,0,0}, {0,1,0}, {0,0,0}};
    int **arry = malloc(sizeof(int *)*m);
    for (int i = 0; i < m; i++) {
        arry[i] = malloc(sizeof(int)*n);
        memcpy(arry[i], a[i], sizeof(int)*n);
    }
    sum = uniquePathsWithObstacles(arry, 3, &m);
    printf("%d", sum);
}