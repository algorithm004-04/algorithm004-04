# NOTE
不同路径2
状态转移方程分析
1.先初始化第一个节点，obstacleGrid[0][0] = 1
2.遍历第一行，obstacleGrid[0][j] = obstacleGrid[0][j - 1]，如果有障碍物，设置值为0
3.遍历第一列，obstacleGrid[i][0] = obstacleGrid[i - 1][0]，如果有障碍物，设置值为0
4.如果obstacleGrid[i][j] == 0说明没有障碍物，obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
5.如果obstacleGrid[i][j] == 1说明有障碍物，obstacleGrid[i][j] == 0
所以状态转移方程
if (obstacleGrid[i][j] == 0) {
    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
} else {
    obstacleGrid[i][j] == 0
}

  

