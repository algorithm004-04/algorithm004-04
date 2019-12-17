#
# @lc app=leetcode.cn id=32 lang=python3
#
# [32] 最长有效括号
#
# https://leetcode-cn.com/problems/longest-valid-parentheses/description/
#
# algorithms
# Hard (28.37%)
# Likes:    375
# Dislikes: 0
# Total Accepted:    26.7K
# Total Submissions: 93.7K
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
        if (not s):
            return 0
        dp = [0] * len(s)
        maxLen = 0
        for i in range(1, len(s)):
            if(s[i]==")"):
                if(s[i-1]=="("):
                    dp[i]=dp[i-2]+2
                if(s[i-1]==")" and i-dp[i-1]-1>=0 and s[i-dp[i-1]-1]=="("):
                    dp[i]=dp[i-1]+dp[i-dp[i-1]-2]+2

            maxLen = max(maxLen, dp[i])
 
        return maxLen
        
# @lc code=end

