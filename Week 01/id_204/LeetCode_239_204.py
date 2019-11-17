'''
Descripe:
1.给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

Author: 大宇

Week 01 Homework

'''

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        for i in range(len(nums)-1, 0, -1):
            if nums[i] == nums[i-1]: nums.pop(i)
        return len(nums)