class Solution:
    def numDecodings(self, s: str) -> int:
        dp = [0] * len(s)
        if s[0] == "0":
            return 0
        else:
            dp[0] = 1
        if len(s) == 1: return dp[-1]
        if s[1] != "0":
            dp[1] += 1
        if 10 <= int(s[:2]) <= 26:
            dp[1] += 1
        for i in range(2, len(s)):
            if s[i - 1] + s[i] == "00": return 0
            if s[i] != "0":
                dp[i] += dp[i - 1]
            if 10 <= int(s[i - 1] + s[i]) <= 26:
                dp[i] += dp[i - 2]
        return dp[-1]
