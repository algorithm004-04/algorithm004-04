class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2: return n
        first, second = 1, 2
        for i in range(n-2):
            first, second = second, first + second
        return second