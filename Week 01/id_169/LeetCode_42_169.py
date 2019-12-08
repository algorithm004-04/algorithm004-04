from typing import List

class Solution:
    """
    栈
    """
    def trap(self, height: List[int]) -> int:
        if len(height) < 3: return 0
        result, stack = 0, []
        for i in range(len(height)):
            while len(stack) > 0 and height[i] > height[stack[-1]]:
                top = stack.pop()
                if len(stack) == 0: break
                if height[stack[-1]] == height[top]: continue
                width = i - stack[-1] - 1
                print(width)
                result += width * (min(height[stack[-1]], height[i]) - height[top])
                print(result)
            stack.append(i)
        return result

    """
    暴力法
    """
    def trap2(self, height: List[int]) -> int:
        if len(height) < 3: return 0
        rains = 0
        for i in range(1, len(height) - 1):
            h = min(max(height[:i]), max(height[i+1:])) - height[i]
            if h < 0: h = 0
            rains += h
        return rains

print(Solution().trap([0,1,0,2,1,0,1,3,2,1,2,1]))
