class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # dp[i] 的值代表 nums 前 i 个数字的最长子序列长度。
        # 转移方程 dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)
        if not nums: return 0
        dp = [1] * len(nums)
        for i in range(len(nums)):
            for j in range(i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)
