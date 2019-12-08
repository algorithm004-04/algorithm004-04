class Solution {
    public int minDistance(String word1, String word2) {

        String newWord1 = "#" + word1;
        String newWord2 = "#" + word2;

        int m = newWord1.length();
        int n = newWord2.length();
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }

                if (newWord1.charAt(i) == newWord2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }

                dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.minDistance("abc", "abcde");
    }
}