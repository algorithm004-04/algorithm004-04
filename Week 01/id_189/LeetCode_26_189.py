#
# @lc app=leetcode.cn id=26 lang=python
#
# [26] 删除排序数组中的重复项
#

# 1. 双指针


# @lc code=start
class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        j = 1
        for i in range(1, len(nums)):
            if nums[i] > nums[i-1]:
                nums[j] = nums[i]
                j += 1

        return j


        
# @lc code=end

