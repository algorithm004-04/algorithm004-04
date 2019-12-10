from collections import deque

class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if len(height) <= 2:
            return 0
        left_max = [height[0]]
        for i in xrange(1, len(height)):
            # left_max[i] must >= height[i], otherwise will produce negative value
            left_max.append(max(height[i], left_max[i-1]))
        right_max, j = [height[-1]], 1
        for i in reversed(xrange(0, len(height)-1)):
            #print(i, j)
            right_max.append(max(height[i], right_max[j-1]))
            j += 1
        ans = 0
        for i in xrange(1, len(height)-1):
            # ans >= 0
            ans += min(left_max[i], right_max[len(height)-1-i]) - height[i]
        return ans
