#
# @lc app=leetcode.cn id=11 lang=python
#
# [11] 盛最多水的容器
#

# 1. 暴力破解，全部循环。
# 2019.10.19 提交- 超出时限

# @lc code=start
class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        maxarea = 0

        for i in range(len(height)):
            for j in range(i+1, len(height)):
                area = (j - i) * min(height[i], height[j])
                maxarea = max(area, maxarea)
        return maxarea


        
# @lc code=end

# 2. 左右夹逼
# 2019.10.19 通过

# @lc code=start

class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        maxarea = 0
        i = 0
        j = len(height)-1

        while i < j:
            area = (j - i) * min(height[i], height[j])
            maxarea = max(area, maxarea)
            
            if height[i] < height[j]:
                i += 1
            else:
                j -= 1
        return maxarea

        
# @lc code=end


