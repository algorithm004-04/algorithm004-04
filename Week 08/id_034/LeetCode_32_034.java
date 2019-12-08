/**
 * LeetCode_32_034
 * 最长有效括号
 * @Author blackberry
 * @Date 2019/12/8 4:59 PM
 **/
class Solution32 {

    public int longestValidParenttherses(String s) {
        int len = s.length();
        int max = 0;

        int[] dp = new int[len];

        for (int i = 1; i < len; i ++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i > dp[i - 1] && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
