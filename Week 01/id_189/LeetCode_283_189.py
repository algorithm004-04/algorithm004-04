#
# @lc app=leetcode.cn id=283 lang=python
#
# [283] 移动零
#
#

# 1. 遍历数组，遇到 0 删除，并在结尾加上 0 
# 2019.10.18 通过


# @lc code=start
class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        for n in nums:
            if n == 0:
                nums.remove(n)
                nums.append(0)
        
# @lc code=end

# 2. 用两个下标。参考 LeetCode 高分答案（Java)
# 2019.10.19 通过

# @lc code=start
class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        j  = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[j] = nums[i]
                j+=1
            i+=1
        while j < len(nums):
            nums[j] = 0
            j+=1
        
# @lc code=end

# 3. 两个下标，交换位置。参考 LeetCode 高分答案（Python)
# 2019.10.19 通过

# @lc code=start
class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        j = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[i], nums[j] = nums[j], nums[i]
                j += 1

# @lc code=end

