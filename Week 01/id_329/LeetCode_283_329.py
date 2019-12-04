# coding=utf-8

"""
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]

说明:
    必须在原数组上操作，不能拷贝额外的数组。
    尽量减少操作次数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/move-zeroes
"""

from typing import List


class Solution:
    # violent
    # def moveZeroes(self, nums: List[int]) -> None:
    #     """
    #     Do not return anything, modify nums in-place instead.
    #     """
    #     zero_num = 0
    #     while 1:
    #         try:
    #             nums.remove(0)
    #             zero_num += 1
    #         except ValueError:
    #             break
    #     for _ in range(zero_num):
    #         nums.append(0)
    #     return

    # #another expression for violent
    # def moveZeroes(self, nums: List[int]) -> None:
    #     """
    #     Do not return anything, modify nums in-place instead.
    #     """
    #     zero_num = 0
    #     for num in nums:
    #         if num == 0:
    #             zero_num += 1
    #     for _ in range(zero_num):
    #         nums.remove(0)
    #         nums.append(0)
    #     return

    # two-point
    # insert non-0 before 0 value
    def moveZeroes(self, nums: List[int]) -> None:
        slow = 0
        for fast in range(len(nums)):
            if nums[fast] != 0:
                nums[slow], nums[fast] = nums[fast], nums[slow]
                slow += 1
        return
