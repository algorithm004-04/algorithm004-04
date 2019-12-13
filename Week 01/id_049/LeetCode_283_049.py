class Solution:
    def moveZeroes(self, nums):
        i=0
        for j in range(len(nums)):
            if nums[j] != 0:
                nums[i],nums[j]=nums[j],nums[i]
                i+=1
        return nums
        