class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        m, n = len(word1), len(word2)
        if m == 0 and n == 0:
            return 0
        if m == 0:
            return n 
        if n == 0:
            return m
        
        dp = [[0 for i in range(m+1)] for _ in range(n+1)]
        
        for i in range(m):
            dp[0][i] = i
            
        for j in range(n):
            dp[j][0] = j
        
        for i in range(1, m):
            for j in range(1, n):
                if word1[i] == word2[j]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
        return dp[-1][-1]