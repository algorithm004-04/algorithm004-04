/**
 * 最大子序和 https://leetcode-cn.com/problems/maximum-subarray/
 * @param {number[]} nums
 * @return {number}
 * 思路：dp[i] = max(nums[i],nums[i] + dp[i - 1])
 * 最大子序和 = 当前元素自身最大或者 当前元素+之前最大
 */
var maxSubArray = function (nums) {
    let max = nums[0]
    const dp = []
    dp[0] = max
    for (let i = 1; i < nums.length; i++) {
        dp[i] = Math.max(nums[i], nums[i] + dp[i - 1])
        max = Math.max(max, dp[i])
    }
    return max
};

//优化
var maxSubArray = function (nums) {
    let max = Number.MIN_SAFE_INTEGER;
    let prev = 0;
    for (var i = 0; i < nums.length; i++) {
        prev = Math.max(prev + nums[i], nums[i])
        max = Math.max(max, prev);
    }
    return max;
};