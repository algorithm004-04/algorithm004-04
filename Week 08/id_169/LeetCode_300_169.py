from typing import List

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        dp = [1] * len(nums)
        for i in range(1, len(nums)):
            dpi = 0
            for j in range(0, i):
                if nums[j] < nums[i]:
                    dpi = max(dp[j], dpi)
            dp[i] = dpi + 1
        return max(dp)
