class Solution:
    def longestValidParentheses(self, s):
        n = len(s)
        if n== 0: return 0
        dp = [0] * n
        res = 0
        for i in range(n):
            if s[i] == ")" and i - dp[i - 1] - 1 >= 0 and s[i - dp[i - 1] - 1] == "(":
                dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2]
                res = max(res, dp[i])
        return res        

