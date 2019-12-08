/**
 * LeetCode_64_034
 * 最小路径和
 * @Author blackberry
 * @Date 2019/11/17 7:29 PM
 **/
public class LeetCode_64_034 {

    /**
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] dp  = new int[row][col];

        for (int i = 0; i < col; i ++) {
            for (int j = 0; j < row; j ++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[row - 1][col - 1];
    }

    public int minPathSum1(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[] dp = new int[col];

        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[i][j];
                } else if (i == 0) {
                    dp[j] = grid[i][j] + dp[j - 1];
                } else if (j == 0) {
                    dp[j] = grid[i][j] + dp[j];
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[col - 1];
    }

}
