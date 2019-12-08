# coding=utf-8

"""
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。

示例 1:
输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。

示例 2:
输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game
"""
from typing import List


class Solution:
    # 关键是思路
    # 代码极简
    def canJump(self, nums: List[int]) -> bool:
        last = len(nums) - 1
        # -1 是因为要包括索引0
        for i in range(last, -1, -1):
            if i + nums[i] >= last:
                last = i
        return last == 0

    def canJump2(self, nums):
        m = 0
        for i, n in enumerate(nums):
            if i > m:
                return False
            m = max(m, i+n)
        return True


if __name__ == '__main__':
    sol = Solution()
    params = [
        ([2,3,1,1,4], True),
        ([3,2,1,0,4], False)
    ]
    for param in params:
        assert sol.canJump(param[0]) == param[1]
