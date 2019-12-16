class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        for i, var in enumerate(nums):
            if target - var in nums[i+1:]:
                return [i, nums[i+1:].index(target-var)+i+1]
