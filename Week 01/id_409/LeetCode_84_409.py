class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        max_area = 0
        for i in range(len(heights)):
            while len(stack)!=0 and heights[stack[-1]] > heights[i]:
                height = heights[stack.pop()]
                left = stack[-1] if stack else -1
                max_area = max(max_area, height * (i - left -1))
            stack.append(i)
        while stack:
            height = heights[stack.pop()]
            left = stack[-1] if stack else -1
            max_area = max(max_area, height * (len(heights) - 1 - left))

        return max_area