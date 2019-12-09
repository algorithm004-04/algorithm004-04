class Solution:
    def longestValidParentheses(self, s: str) -> int:
        if not s:
            return 0
        dp = [0] * len(s)
        for i in range(1, len(s)):
            if s[i] == ')' and s[i- 1] == '(':
                dp[i] = dp[i - 2] + 2
            elif s[i] == ')' and s[i - 1] == ')' and s[i - dp[i - 1] - 1] == '(' and i - dp[i - 1] > 0:
                dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
        return max(dp)
