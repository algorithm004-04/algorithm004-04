#20191025

"""
    笨递归，O(2^n)
    重复计算过多
"""
# class Solution:
#     def climbStairs(self, n):
#         if n == 1:
#             return 1
#         if n == 2:
#             return 2
#         return self.climbStairs(n - 1) + self.climbStairs(n - 2)

"""
    递归
    记录计算过的数据
    每个数值值计算一次（O(n)）
"""

# class Solution:
#     def climbStairs(self, n):
#         mem = [0]*(n+1) # 先建立一个n+1 长度的数组，并置为0
#         return self.climbStairsMem(n , mem)
         
#     def climbStairsMem(self, n, mem):
#         if 1 == n:
#             return 1
#         if n == 2:
#             return 2
        
#         if mem[n] != 0:
#             return mem[n]
        
#         mem[n] = self.climbStairsMem(n - 1, mem) + \
#             self.climbStairsMem(n - 2, mem)
        
#         return mem[n]


"""
    动态规划
    1. f(n) = f(n - 1) + f(n - 2)
    * n 从下标0 开始所以输出 n-1
    每个数值只计算一次O(n)
"""

# class Solution:
#     def climbStairs(self, n):
#         if n == 1:
#             return 1
#         if n == 2:
#             return 2
#         dp = [-1 for i in range(n)]
#         dp[0] = 1
#         dp[1] = 2
#         for i in range(2, n):
#             dp[i] = dp[i - 1] + dp[i - 2]
#         return dp[n-1]

"""
    动态规划（不记录）
    每个数值只计算一次O(n)
"""
class Solution:
    def climbStairs(self, n):
        if n == 1:
            return 1
        if n == 2:
            return 2
        first = 1
        second = 2
        for i in range(2, n):
            dp = first + second
            first, second = second, dp
        return dp


s = Solution()
print(s.climbStairs(30))
print(s.climbStairs(1))
print(s.climbStairs(2))
print(s.climbStairs(3))


