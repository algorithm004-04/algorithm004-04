/*
 * @lc app=leetcode.cn id=312 lang=java
 *
 * [312] 戳气球
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        int n = 1;
        for (int x : nums)
            if (x > 0)
                newNums[n++] = x;
        newNums[0] = newNums[n++] = 1;


        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] =
                            Math.max(dp[left][right], newNums[left] * newNums[i] * newNums[right]
                                    + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }
}
// @lc code=end

