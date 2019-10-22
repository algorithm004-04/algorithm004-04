#
# @lc app=leetcode id=189 lang=python
#
# [189] Rotate Array
#


# 1. 后延 k 个，再从头开始赋值

# @lc code=start
class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """

        length = len(nums)
        k = k % length

        if k == 0: return nums

        # 延长列表 k 长度，填 0 
        nums += ([0] * k)

        # 列表后延 k 个
        for j in range(len(nums)-1,k-1,-1):
            nums[j] = nums[j-k]

        # 从头赋值
        for i in range(k):
            nums[i] = nums[length+i]

        # 删除后面 k 个
        for i in range(k):
            nums.pop()

        return nums
        
# @lc code=end

