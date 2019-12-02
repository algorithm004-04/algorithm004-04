package weak_05;

public class LeetCode_32_234 {

  /*
   * dp[] 记录下标i最长连续有效括号长度
   * 1.s[i] == '(' 时 dp[i]=0
   * 2.s[i] == ')' 时
   *   2.1 若s[i-1] == '(' 则s[i]+s[i-1] = 2 即dp[i] = dp[i-2]+2
   *   2.2 若s[i-1] == ')' 时 说明可能存在连续()区间 如(()),((()))...
   *       此时如果s[i-dp[i-1]-1] == '(' 则dp[i]=dp[i-1]+2+dp[i-dp[i-1]-2]
   * */
  public int longestValidParentheses(String s) {
    if (s == null || s.length() == 0) return 0;
    int[] dp = new int[s.length()];
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      if (i > 0 && s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(') {
          dp[i] = (i - 2 >= 0 ? dp[i - 2] + 2 : 2);
        } else if (s.charAt(i - 1) == ')'
            && i - dp[i - 1] - 1 >= 0
            && s.charAt(i - dp[i - 1] - 1) == '(') {
          dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
        }
      }
      res = Math.max(res, dp[i]);
    }
    return res;
  }
}
