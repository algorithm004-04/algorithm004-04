"""
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
"""

# Two pointers
class Solution:
    def trap(self, height: List[int]) -> int:
        start, end = 0, len(height)-1
        left_max = right_max = 0
        res = 0

        while start < end:
            if height[start] < height[end]:
                left_max = max(height[start], left_max)
                res += left_max - height[start]
                start += 1
            else:
                right_max = max(height[end], right_max)
                res += right_max - height[end]
                end -= 1

        return res

