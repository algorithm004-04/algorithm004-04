# https://leetcode-cn.com/problems/longest-valid-parentheses/
# 32. 最长有效括号
# DP
# test case => (，(), ((), ()), (()), ()(())
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
                # 1. 每个左括号字符对应的下标i，dp[i]的值必为0
                leftCount += 1
            elif leftCount > 0:
                # 2. 每遇到右括号，判断是否还有左括号未使用，此时dp[i]个字符构成一个有效子串
                dp[i] = dp[i-1] + 2
                # 3. 将下标往前推i-dp[i]，检测已知的有效子串前面是否还有有效子串
                # 例如：[()]()和[()](())，[]是待探寻的可能有效的子串，[]之外是已探寻的
                dp[i] += (dp[i-dp[i]] if i-dp[i] > 0 else 0)
                leftCount -= 1
                res = max(res, dp[i])
        return res