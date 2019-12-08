class Solution {
    // public int longestValidParentheses(String s) {
    //     /*
    //     * DP 
    //     * 1.重复性（分治） 
    //     * 2.定义状态数组  int dp[]
    //     * 3.DP方程： 
    //     *  ...() dp[i] = dp[i-2] + 2
    //     *  ...)) dp[i] = dp[i-1] + dp[i - dp[i-1] - 2] + 2
    //     */
    //     int res = 0;
    //     int dp[] = new int[s.length()];
    //     for(int i = 1; i < s.length(); i++) {
    //      if(s.charAt(i) == ')') {
    //          if(s.charAt(i-1) == '(') {
    //              dp[i] = (i > 2 ? dp[i-2] : 0) + 2;
    //             } else if(i  -dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) == '(') {
    //              dp[i] = dp[i-1] + (i-dp[i-1] >= 2 ? dp[i-dp[i-1]-2] : 0) + 2;
    //             }
    //          res = Math.max(res, dp[i]);
    //      }
    //     }
    //     return res;
    // }
    
    //简化
    public int longestValidParentheses(String s) {
        /*
        * DP 
        * 1.重复性（分治） 
        * 2.定义状态数组  int dp[]  leftCount
        * 3.DP方程：
        *  ...)或...( dp[i] = dp[i-1] + 2 + dp[i - dp[i]] 
        */
        int[] dp = new int[s.length()];
        int result = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (leftCount > 0){
                dp[i] = dp[i - 1] + 2;
                dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
                result = Math.max(result, dp[i]);
                leftCount--;
            }
        }
        return result;
    }
}