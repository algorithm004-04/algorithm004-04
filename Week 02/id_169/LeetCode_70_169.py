class Solution:
    caches = {}

    def climbStairs(self, n: int) -> int:
        """
        递归+缓存
        """
        if n < 3:
            return n
        if n in self.caches:
            return self.caches[n]
        self.caches[n] = self.climbStairs(n - 2) + self.climbStairs(n - 1)
        return self.caches[n]

    def climbStairs2(self, n: int) -> int:
        """
        动态规划
        """
        if n < 3:
            return n
        dp = {
            1: 1,
            2: 2,
        }
        for i in range(3, n + 1):
            dp[i] = dp[i - 2] + dp[i + 1]
        return dp[n]


print(Solution().climbStairs(10))
