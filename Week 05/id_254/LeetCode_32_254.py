class Solution:
    def longestValidParentheses(self, s: str) -> int:
      L = len(s)
      if L == 0:
          return 0
      max = 0
      dp = [0]*L
      for i in range(1, L):
        if s[i] == ")":
            if s[i - 1] == "(":
                dp[i] = dp[i - 2] + 2
            elif s[i - 1] == ")" and i - dp[i - 1] - 1 >= 0 and s[i - dp[i - 1] - 1] == "(":
                dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2]
            if dp[i] > max:
                max = dp[i]
      return max
