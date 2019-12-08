class Solution:
    def longestValidParentheses(self, s: str) -> int:
        if len(s) < 2: return 0
        dp = [0] * len(s)
        for i in range(1, len(s)):
            if s[i] == '(': continue
            if s[i - 1] == '(':
                if i - 2 > -1:
                    dp[i] = dp[i - 2] + 2
                else:
                    dp[i] = 2
            else:
                match = i - dp[i - 1] - 1
                if match < 0 or s[match] == ')': continue
                if match > 0:
                    l = dp[match - 1]
                else:
                    l = 0
                dp[i] = dp[i - 1] + l + 2
        return max(dp)
