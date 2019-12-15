/**
 * LeetCode_115_034
 * 不同子序列
 * @Author blackerry
 * @Date 2019/12/8 5:08 PM
 **/
public class LeetCode_115_034 {

    public int numDistinct(String s, String t) {
        int n1 = t.length();
        int n2 = s.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n2; i ++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= n1; i ++) {
            for (int j = i; j <= n2; j ++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[n1][n2];
    }
}
