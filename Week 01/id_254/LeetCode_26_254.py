class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i = 0
        for val in nums:
            if nums[i] != val:
                i = i+1
                nums[i] = val
        return i+1
