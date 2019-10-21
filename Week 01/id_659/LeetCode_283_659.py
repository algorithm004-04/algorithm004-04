#
# @lc app=leetcode.cn id=283 lang=python3
#
# [283] 移动零
#

# @lc code=start
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        j =0
        for i in range(len(nums)):
            if nums[i]!=0:
                nums[i],nums[j]=nums[j],nums[i]
                j+=1

        
# @lc code=end

