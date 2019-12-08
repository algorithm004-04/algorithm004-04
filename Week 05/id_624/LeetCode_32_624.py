#
# @lc app=leetcode.cn id=32 lang=python3
#
# [32] 最长有效括号
#
# https://leetcode-cn.com/problems/longest-valid-parentheses/description/
#
# algorithms
# Hard (28.44%)
# Likes:    386
# Dislikes: 0
# Total Accepted:    27.6K
# Total Submissions: 96.3K
# Testcase Example:  '"(()"'
#
# 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
# 
# 示例 1:
# 
# 输入: "(()"
# 输出: 2
# 解释: 最长有效括号子串为 "()"
# 
# 
# 示例 2:
# 
# 输入: ")()())"
# 输出: 4
# 解释: 最长有效括号子串为 "()()"
# 
# 
#

# @lc code=start
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        dp, ans = [0]*len(s), 0
        for i in range(1, len(s)):
            if s[i] == "(": continue
            if s[i - 1] == "(":
                dp[i] = 2 + (dp[i - 2] if i > 1 else 0)
            else:
                # 前一个）的有效串的（的位置，若该位置的前一个字符串是"("，该判断才有效，因为这个（正是拼配了当前的）
                lli = i - dp[i - 1]
                if lli > 0 and s[lli-1] == "(": 
                    dp[i] = dp[i - 1] + 2
                    if lli >= 2: dp[i] += dp[lli - 2]
            ans = max(ans, dp[i])
        return ans

# @lc code=end