import java.util.Arrays;

public class LeetCode_62_不同路径 {

    /*
        使用排列组合来做
            代码略
     */

    /*
        动态规划
            dp[i][j] = dp[i-1][j] + dp[i][j-1]
        时间复杂度：O(m * n) 时间复杂度O(m * n)
     */

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    /*
        动态规划 优化
            时间复杂度O(m * n)  空间复杂度O(n)

     */
    public int uniquePaths1(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }

}
