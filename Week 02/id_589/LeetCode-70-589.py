#
# @lc app=leetcode id=70 lang=python3
#
# [70] Climbing Stairs
#

# @lc code=start
class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1
        elif n == 2:
            return 2
        li = [-1 for i in range(n)] #列表推导式
        li[0],li[1] = 1, 2
        return self.helper(n-1, li)

    def helper(self, n, li):
        if li[n] < 0:
            li[n] = self.helper(n-1,li) + self.helper(n-2,li)
        return li[n]
    



        
# @lc code=end

