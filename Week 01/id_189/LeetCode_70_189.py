#
# @lc app=leetcode.cn id=70 lang=python
#
# [70] 爬楼梯
#

# 2019.10.19 通过

# @lc code=start
class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        
        if n < 3:
            return n     

        f1, f2 = 1, 2  
        for i in range(3, n+1):
            f3 = f2 + f1
            f1 = f2
            f2 = f3

        return f3    
# @lc code=end

