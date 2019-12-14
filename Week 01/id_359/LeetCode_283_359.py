class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        # cursor to put value not zero
        j = 0
        # time O(n) space O(1)
        for i in range(len(nums)):
            if nums[i] != 0:
                if i != j:
                    nums[j], nums[i] = nums[i], 0
                j += 1
