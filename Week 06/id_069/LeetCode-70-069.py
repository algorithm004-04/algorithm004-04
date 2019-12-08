# 20191112



# 单递归
class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1
        if n == 2:
            return 2
        return self.climbStairs(n-1) + self.climbStairs(n-2)

# 存储中间结果的递归
class Solution:
    def climbStairs(self, n: int) -> int:
        mem = [-1] * (n+1)
        if n == 1:
            return 1
        if n == 2:
            return 2

        self.climb_Stairs(n, mem)
        return mem[n]

    def climb_Stairs(self, n, mem):
        if n == 1:
            return 1
        if n == 2:
            return 2
        if mem[n] != -1:
            return mem[n]
        mem[n] = self.climb_Stairs(n-1, mem) + self.climb_Stairs(n-2, mem)
        return mem[n]

# 斐波那契数列
class Solution:
    def climbStairs(self, n: int) -> int:
        a, b = 1, 1
        for _ in range(n):
            a, b = b, a+b
        return a




testNum = 10
s = Solution()
print(s.climbStairs(testNum))
print(s.climbStairs(2))
print(s.climbStairs(3))
print(s.climbStairs(10))
print(s.climbStairs(100))
