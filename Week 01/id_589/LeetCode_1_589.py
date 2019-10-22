#
# @lc app=leetcode id=1 lang=python3
#
# [1] Two Sum
#

# @lc code=start
class Solution:
    # @return a tuple, (index1, index2)
    # 8:42
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for i, val in enumerate(nums):
            if val not in map:
                map[target-val] = i
            else:
                return [map[val],i]
        return []

        
# @lc code=end

