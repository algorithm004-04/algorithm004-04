/**打家劫舍  https://leetcode-cn.com/problems/house-robber
 * @param {number[]} nums
 * @return {number}
 * 思路：当前房子n的最大值 = Math.max(当前房屋的值+(n-2的值)，n-2的值)
 */
var rob = function (nums) {
    const len = nums.length;
    if (len == 0)
        return 0;
    const dp = [];
    dp[0] = 0;
    dp[1] = nums[0];
    for (let i = 2; i <= len; i++) {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
    }
    return dp[len];
}