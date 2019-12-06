# 20191117

"""
DP:
    a. 分治 max_sum(i) = max(max_sum(i-1), 0) + a[i]
    b. 状态数组定义： f[i]
    c. 状态转移方程： f[i] = max(f[i-1], 0) + a[i]

"""
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        dp = nums
        for i in range(1, len(nums)):
            dp[i] = max(0, dp[i-1]) + nums[i]

        return max(dp)