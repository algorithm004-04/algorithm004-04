#
# @lc app=leetcode.cn id=11 lang=python3
#
# [11] 盛最多水的容器
#

# @lc code=start
class Solution:
    def maxArea(self, height: List[int]) -> int:
        maxArea = 0
        left, right = 0, len(height)-1
        while left < right:
            minHeight = min(height[left], height[right])
            maxArea = max(maxArea, minHeight * (right - left))
            if height[left] < height[right]:
                left += 1
            else:
                right -=1
            
        return maxArea

# @lc code=end

