package week_05.lesson12;

public class MinimumPathSum {

    /**
     * 最优子结构：opt[n][m] = Math.min(opt[n-1][m],opt[n][m-1])
     * 中间储存状态：dp[n][m]
     * DP方程：dp[n][m] = Math.min(dp[n-1][m],dp[n][m-1]) + grid[n][m]
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {

        if (null == grid || grid.length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        dp[0][0] = grid[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];


    }

    public static void main(String[] args) {

    }
}
