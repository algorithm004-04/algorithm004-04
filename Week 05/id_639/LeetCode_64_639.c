/*
	a. subproblem 
	b. dp状态数组		f[i,j] = min(f[i+1,j],f[i+1,j+1]) + a[i,j]
	c. dp状态方程
	
	调试了半天，发现自己的数组写好才能了 a[i,j] 这样是可以访问编辑器没有提示报错，结果调试了很久
	通过这个小问题，还是认识到了就算道理你都懂，也不一定可以写出可以使用的代码   =》 理论 + 实践
*/

int minNum(int a,int b) {
    if (a < b){
        return a;
    }
    return b;
}
 
int minPathSum(int** grid, int gridSize, int* gridColSize){
    int i,j,col,column;
    
    // 初始化
    col = gridColSize[gridSize-1];
    for (i = col-2 ;i>=0;i--) {
        grid[gridSize-1][i] = grid[gridSize-1][i] + grid[gridSize-1][i+1];
    }
    
    for (j = gridSize-2; j>=0; j--) {
        grid[j][col-1] = grid[j][col-1] + grid[j+1][col-1];
    }
    
    for (i = gridSize-2;i >= 0;i--) {
        for (j = col-2;j >=0;j--) {
           grid[i][j] = (minNum(grid[i+1][j],grid[i][j+1]) + grid[i][j]);
        }
    }
    
    return grid[0][0];
}