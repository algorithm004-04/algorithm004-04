class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if k == 0: return nums
        if k > len(nums): k = k - len(nums)
        nums[:k], nums[k:] = nums[-k:], nums[:-k]
        return nums


class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        k%=len(nums)
        nums[:k],nums[k:] = nums[-k:],nums[:len(nums)-k]
        return nums
