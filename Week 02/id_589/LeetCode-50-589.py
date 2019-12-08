#
# @lc app=leetcode id=50 lang=python3
#
# [50] Pow(x, n)
#

# @lc code=start
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n < 0:
            return 1/self.helper(x, -n)
        else:
            return self.helper(x,n)


    def helper(self, x:float, n:int) -> float:
        if n == 0:
            return 1

        half = self.helper(x, n//2) # 必须整除
        if n%2 == 0:
            return half * half
        if n%2 == 1:
            return half * half * x

        
# @lc code=end

