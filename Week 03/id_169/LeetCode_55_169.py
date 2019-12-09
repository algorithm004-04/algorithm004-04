from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) <= 1: return True
        endReachable = len(nums) - 1
        for i in range(len(nums) - 2, -1, -1):
            if nums[i] + i >= endReachable:
                endReachable = i
        return endReachable == 0
