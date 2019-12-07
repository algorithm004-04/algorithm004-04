class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        lastNonZero = 0
        cur = 0
        while cur < len(nums):
            if nums[cur] != 0:
                nums[lastNonZero], nums[cur] = nums[cur], nums[lastNonZero]
                lastNonZero += 1
            cur += 1