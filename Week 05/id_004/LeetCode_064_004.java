class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        //初始化最后一行
        for (int j = n - 1; j >= 0; j--) {
            if (j == n - 1) {
                dp[m - 1][j] = grid[m - 1][j];
            } else {
                dp[m - 1][j] = grid[m - 1][j] + dp[m - 1][j + 1];
            }
        }

        //初始化最后一列
        for (int j = m - 1; j >= 0; j--) {
            if (j == m - 1) {
                dp[j][n - 1] = grid[j][n - 1];
            } else {
                dp[j][n - 1] = grid[j][n - 1] + dp[j + 1][n - 1];
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 4, 8}, {3, 2, 2, 4}, {5, 7, 1, 9}, {2, 3, 2, 3}};
        Solution s = new Solution();
        s.minPathSum(grid);
    }
}
