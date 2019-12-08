# 20191027

"""
    解法1：
        暴力法
"""
# class Solution:
#     def myPow(self, x: float, n: int) -> float:
#         ans = 1
#         if n < 0:
#             n = -n
#             x = 1 / x
#         for i in range(n):
#              ans *= x
#         return ans

"""
    解法2：
        分治
"""

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            n = -n
            x = 1 / x
        return self.fastPow(x, n)

    def fastPow(self, x, n):
        if n == 0:
            return 1.0

        half = self.fastPow(x, n // 2)
        if n % 2 == 0:
            return half * half
        else:
            return half * half * x


s = Solution()
print(s.myPow(2, 10))