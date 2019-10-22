# -*- coding: utf8 -*-




"""
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
"""

class Solution(object):


    def move_zeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        j = 0
        for i in range(n):
            if nums[i] != 0:
                nums[j] = nums[i]
                j+=1
        for k in range(j,n):
            nums[k] = 0


if __name__ == '__main__':
    slt = Solution()
    nums = [0, 1, 0, 3, 12]
    slt.move_zeroes(nums)