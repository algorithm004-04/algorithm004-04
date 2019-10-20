# -*- coding: utf8 -*-

"""
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

直观想法

直接按问题描述进行。对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
"""


class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """

        n = len(height)
        ans = 0
        for i in range(n):
            j = i
            k = i
            max_left = 0
            max_right = 0
            while j >=0:
                max_left = max(max_left,height[j])
                j-=1
            while k < n:
                max_right = max(max_right,height[k])
                k+=1
            ans += min(max_right,max_left) - height[i]
        print(ans)
        return ans



if __name__ == '__main__':
    height = [0,1,0,2,1,0,1,3,2,1,2,1]
    slt = Solution()
    slt.trap(height)
