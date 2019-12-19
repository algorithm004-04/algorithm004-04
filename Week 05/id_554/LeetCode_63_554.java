package com.kkkkkk.demovvorld.leetcode63;

public class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return -1;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        // initilize opt[][]
        int maxM = obstacleGrid.length;
        int maxN = obstacleGrid[0].length;
        int[][] opt = new int[maxM][maxN];
        // 若一行中，靠近出口的位置i有障碍物，位置i之前的所有能走出的方法为0
        for (int i = 0; i < maxN; ++i) {
            if (obstacleGrid[0][i] == 1) {
                for (int j = i; j < maxN; ++j) {
                    opt[0][j] = 0;
                }
                break;
            }
            opt[0][i] = 1;
        }
        // 同理，列
        for (int p = 0; p < maxM; ++p) {
            if (obstacleGrid[p][0] == 1) {
                for (int q = p; q < maxM; ++q) {
                    opt[q][0] = 0;
                }
                break;
            }
            opt[p][0] = 1;
        }
        // dp - 无论从入口到出口 还是 出口到入口，路线数不变
        for (int x = 1; x < maxM; ++x) {
            for (int y = 1; y < maxN; ++y) {
                if (obstacleGrid[x][y] == 1) {
                    opt[x][y] = 0;
                } else {
                    opt[x][y] = opt[x - 1][y] + opt[x][y - 1];
                }
            }
        }
        return opt[maxM - 1][maxN - 1];
    }

    public static void main(String[] args) {
//        int[][] obstacleGrid = {
//                {0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 1},
//                {0, 0, 0, 1, 0},
//                {0, 0, 1, 0, 0}
//        };
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(new Solution2().uniquePathsWithObstacles(obstacleGrid));
    }
}

