#
# @lc app=leetcode.cn id=84 lang=python3
#
# [84] 柱状图中最大的矩形
#
# https://leetcode-cn.com/problems/largest-rectangle-in-histogram/description/
#
# algorithms
# Hard (37.28%)
# Likes:    294
# Dislikes: 0
# Total Accepted:    16K
# Total Submissions: 42.8K
# Testcase Example:  '[2,1,5,6,2,3]'
#
# 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
# 
# 求在该柱状图中，能够勾勒出来的矩形的最大面积。
# 
# 
# 
# 
# 
# 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
# 
# 
# 
# 
# 
# 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
# 
# 
# 
# 示例:
# 
# 输入: [2,1,5,6,2,3]
# 输出: 10
# 
#

# @lc code=start
class Solution:
    def largestRectangleArea(self, heights: [int]) -> int:
        # 枚举每根柱子，找到这个柱子可构成的最大面积。例如对于第三根柱子5来说，向左找到第一个比他小的元素是1，向右找到第一个比他小的元素是2，那么包含它的最大面积就是5*(4-1)-1=10
        #这个思路没错，但是由于时间复杂度是O(n^2)，超时了
        maxArea = 0
        for i in range(len(heights)): 
            left, right = i, i
            while left > 0 and heights[left-1] >= heights[i]: 
                left -= 1
            while right < len(heights)-1 and heights[right+1] >= heights[i]: 
                right += 1
            maxArea = max(maxArea, heights[i]*(right-left+1))

        return maxArea

# @lc code=end

