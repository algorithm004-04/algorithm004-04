class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        nos = nums.count(0)
        lens = len(nums)
        if nos != lens:
            for i in reversed(range(lens-1)):
                if nums[i] == 0:
                    nums.pop(i)
                    nums.append(0)
        return nums
