package com.codertoy.week05;

public class Leecode_63_339 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;

        for (int i = obstacleGrid.length - 1; i >= 0; i--) {
            for (int j = obstacleGrid[i].length - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) {
                    if (i == obstacleGrid.length - 1 && j == obstacleGrid[i].length - 1) {
                        obstacleGrid[obstacleGrid.length - 1][obstacleGrid[i].length - 1] = 1;
                        continue;
                    }
                    int gridA = i + 1 < obstacleGrid.length ? obstacleGrid[i + 1][j] : 0;
                    int gridB = j + 1 < obstacleGrid[i].length ? obstacleGrid[i][j + 1] : 0;
                    obstacleGrid[i][j] = gridA + gridB;
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[0][0];
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;

        for (int i = obstacleGrid.length - 1; i >= 0; i--) {
            for (int j = obstacleGrid[i].length - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) {
                    if (i == obstacleGrid.length - 1 && j == obstacleGrid[i].length - 1) {
                        obstacleGrid[obstacleGrid.length - 1][obstacleGrid[i].length - 1] = 1;
                        continue;
                    }
                    int gridA = i + 1 < obstacleGrid.length ? obstacleGrid[i + 1][j] : 0;
                    int gridB = j + 1 < obstacleGrid[i].length ? obstacleGrid[i][j + 1] : 0;
                    obstacleGrid[i][j] = gridA + gridB;
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[0][0];
    }
}
