# coding=utf-8

"""
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
"""
import itertools
from typing import List


class Solution:
    # unbelievable for itertools
    # def permute(self, nums: List[int]) -> List[List[int]]:
    #     return list(itertools.permutations(nums))

    # reback
    def permute(self, nums: List[int]) -> List[List[int]]:
        if len(nums) == 0:
            return []
        result = []
        # 标记所有都未使用
        used = [False] * len(nums)
        self.dfs(nums, 0, [], used, result)
        return result

    def dfs(self, nums: List[int], index: int, tmp: List[int], used: List[bool], res: List[int]) -> None:
        # terminator
        if index == len(nums):
            res.append(tmp.copy())
            return
        for i in range(len(nums)):
            if not used[i]:
                used[i] = True
                tmp.append(nums[i])
                self.dfs(nums, index + 1, tmp, used, res)
                # 状态重置
                used[i] = False
                tmp.pop()
        return
