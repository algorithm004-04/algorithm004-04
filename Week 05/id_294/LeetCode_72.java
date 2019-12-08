package week05;

public class LeetCode_72 {

    /**
     * 状态dp[i,j]，表示word1以第i个字符结尾和word2以第j个字符结尾的字符串的最小编辑距离
     * dp[i,j] = min(dp[i-1,j], min[i,j-1], min[i-1,j-1])
     * base case
     * dp[h,""] = 1
     * dp[h,g] = 1
     * dp[ho,he] -> min(dp[h,he], dp[ho, h], dp[h,h]) + (word1[i] == word2[j] ? 0 : 1)
     * horse ros   (hors ro) (hors ros) (horse ro)
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }

        for(int j = 1; j <= len2; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int min = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {

        int steps = minDistance("horse", "ros");
    System.out.println(steps);
    }
}
