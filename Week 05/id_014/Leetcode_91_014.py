"""
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:
Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
"""

class Solution:
    def numDecodings(self, s: str) -> int:
        dp = [0] * (len(s)+1)
        dp[0] = 1
        dp[1] = 0 if s[0] == '0' else 1
        
        for i in range(2, len(s)+1):
            if 1 <= int(s[i-1]) <= 9:
                dp[i] += dp[i-1]
            if 10 <= int(s[i-2:i]) <= 26:
                dp[i] += dp[i-2]
                
        return dp[len(s)]

# Backtrack - TLE
class Solution:
    def numDecodings(self, s: str) -> int:
        res = []
        self.backtrack(s, 0, [], res)

        return len(res)


    def backtrack(self, s: str, start: int, cur_res: List[str], res: List[List[str]]) -> None:
        if start == len(''.join(cur_res)) == len(s):
            res.append(list(cur_res))

        for i in range(start, len(s)):
            if s[i] == '0':
                continue
            else:
                cur_res.append(s[i])
                self.backtrack(s, i+1, cur_res, res)
                cur_res.pop()

                if start < len(s)-1 and 1 <= int(s[i:i+2]) <= 26:
                    cur_res.append(s[i:i+2])
                    self.backtrack(s, i+2, cur_res, res)
                    cur_res.pop()
