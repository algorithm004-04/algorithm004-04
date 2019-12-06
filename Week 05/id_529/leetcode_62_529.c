#include <stdio.h>
#include <stdlib.h>
int uniquePaths(int m, int n)
{
    int i;
    int j;
    int sum;
    int arry[100][100] = {0};
    /*
    int **arry =(int **) malloc(sizeof(int *) * m);
    int sum;
    for (i = 0; i < m; i++) {
        arry[i] = malloc(sizeof(int) * n);
    }*/
    memset(arry, 0, sizeof(m*n));
    for (i = 0; i < n; i++) {
        arry[0][i] = 1;
    }
    for (j = 0; j < m; j++) {
        arry[j][0] = 1;
    }

    for (i = 1; i < m; i++) {
        for (j = 1; j < n; j++) {
            arry[i][j] = arry[i-1][j] + arry[i][j-1];
        }
    }
    sum = arry[m-1][n-1];
 //   free(arry);
    return sum;
}

void main()
{
    int m = 7; 
    int n = 3;
    int path;
    path = uniquePaths(m, n);
    printf("%d", path);
}