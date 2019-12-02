/**
 * LeetCode_221_034
 *
 * @Author blackberry
 * @Date 2019/11/17 8:29 PM
 **/
public class LeetCode_221_034 {

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;

        int[][] dp = new int[row + 1][col + 1];
        int maxLen = 0;

        for (int i = 1; i <= row; i ++) {
            for (int j = 1; j <= col; j ++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen * maxLen;
    }
}
