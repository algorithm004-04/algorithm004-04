# coding=utf-8

"""
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。

示例:
输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/trapping-rain-water
"""
from typing import List


class Solution:
    # # 暴力法就不写了，思想要了解

    # 用栈实现， python用list实现，官方提供了相应方法
    # 高-低-高，才能储存雨水
    # 当当前高度小于栈顶元素时，才往里压入
    def trap(self, height: List[int]) -> int:
        stack = []
        result = current = 0
        while current < len(height):
            while len(stack) != 0 and height[current] > height[stack[-1]]:
                top = stack.pop()
                if len(stack) == 0:
                    break
                length = current - stack[-1] - 1
                _height = min(height[stack[-1]], height[current]) - height[top]
                result += length * _height
            stack.append(current)
            current += 1
        return result

    # todo: 双指针法，还需要再看看

