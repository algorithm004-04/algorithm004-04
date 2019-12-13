class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) < 2:
            return 0
        dp = [0 for _ in range(len(s))]
        res, leftCount = 0, 0
        for i, c in enumerate(s):
            if c == '(':
                leftCount += 1
            elif leftCount > 0:
                dp[i] = dp[i-1] + 2
                dp[i] += (dp[i - dp[i]] if i - dp[i] > 0 else 0)
                leftCount -= 1
                res = max(res, dp[i])
        return res