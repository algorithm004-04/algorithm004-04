#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashNums = {k: v for v,k in enumerate(nums)}
        for i in range(len(nums)):
            j = hashNums.get(target - nums[i], None)
            if (j is not None) and (i != j):
                return [i, j]
# @lc code=end

