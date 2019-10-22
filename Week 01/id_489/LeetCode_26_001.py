class Solution:
    def removeDuplicates(self, nums):
        if not nums: return 0
        k = 1
        for i in range(1, len(nums)):
            if nums[i] != nums[i-1]:
                nums[k] = nums[i]
                k += 1
        return k


a = Solution()
print(a.removeDuplicates([1, 1, 2, 2, 2, 3, 3, 4, 4, 5]))