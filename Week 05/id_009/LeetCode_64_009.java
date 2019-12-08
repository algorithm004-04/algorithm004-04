/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class LeetCode_64_009 {
    public static void main(String[] args) {
        LeetCode_64_009 test = new LeetCode_64_009();
        int[][] grid = new int[3][3];
        grid[0][0] = 1;
        grid[0][1] = 3;
        grid[0][2] = 1;
        grid[1][0] = 1;
        grid[1][1] = 5;
        grid[1][2] = 1;
        grid[2][0] = 4;
        grid[2][1] = 2;
        grid[2][2] = 1;

        System.out.println(test.minPathSum2(grid));
    }

    /**
     * 动态规划（二维数组）
     *
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];
                } else if (i == 0 && j != 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (i != 0 && j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }


    /**
     * 动态规划（一维数组）
     *
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[i][j];
                } else if (i == 0 && j != 0) {
                    dp[j] = grid[0][j] + dp[j - 1];
                } else if (j == 0 && i != 0) {
                    dp[j] = grid[i][0] + dp[j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }
}
