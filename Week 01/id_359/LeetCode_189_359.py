class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        k = k % len(nums)
        # time O(3n) space O(1)
        self.reverse(nums, 0, len(nums) - 1)
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k, len(nums) - 1)
        
    def reverse(self, nums, i, j):
        while (i < j):
            nums[i], nums[j] = nums[j], nums[i]
            i += 1; j -= 1
