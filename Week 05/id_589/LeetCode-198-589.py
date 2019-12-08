#
# @lc app=leetcode.cn id=198 lang=python3
#
# [198] 打家劫舍
#

# @lc code=start
class Solution:

    """
        dp[i]: 0...i能偷到的max value
        dp[i][0,1]: 一维转二维，增加一个偷与不偷的标志,
        0: 不偷第i间房，1: 偷第i间房
        dp方程：
        dp[i][0] = Max(dp[i-1][0], dp[i-1][1])
        dp[i][1] = dp[i-1][0] + nums[i]
    """

    def rob1(self, nums: List[int]) -> int:
        if len(nums) <= 0:
            return 0

        if len(nums) == 1:
            return nums[0]

        n = len(nums)
        dp = [[0]*2 for i in range(n)]

        dp[0][0] = 0
        dp[0][1] = nums[0]

        for i in range(n):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            dp[i][1] = dp[i-1][0] + nums[i]

        return max(dp[n-1][0], dp[n-1][1])


    """
        dp[i]: 0...i能偷到的max value
        dp[i]: 0...i间房，且nums[i]必偷的最大值
        dp方程：
        dp[i] = max(dp[i-1], dp[i-2] + nums[i])
    """

    def rob(self, nums: List[int]) -> int:
        if len(nums) <= 0:
            return 0

        if len(nums) == 1:
            return nums[0]

        n = len(nums)
        dp = list(range(n))

        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        res = max(dp[0],dp[1])
        for i in range(2, n):
            dp[i] = max(dp[i-1], dp[i-2] + nums[i])
            res = max(res, dp[i])

        return res
        
# @lc code=end

