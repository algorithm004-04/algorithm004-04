class Solution:
    def trap(self, height):
        if len(height) == 0:
            return 0

        stack = []
        curr = 0
        count = 0
        l = len(height)
        while curr < l:
            while len(stack) > 0 and height[curr] > height[stack[-1]]:
                top = stack.pop()
                if len(stack) == 0:
                    break
                dis = curr - stack[-1] - 1
                count = count + (min(height[curr], height[stack[-1]]) - height[top]) * dis

            stack.append(curr)
            curr = curr+1

        return count
