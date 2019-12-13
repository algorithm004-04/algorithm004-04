#
# @lc app=leetcode.cn id=917 lang=python3
#
# [917] 仅仅反转字母
#
# https://leetcode-cn.com/problems/reverse-only-letters/description/
#
# algorithms
# Easy (50.54%)
# Likes:    31
# Dislikes: 0
# Total Accepted:    6.7K
# Total Submissions: 12.8K
# Testcase Example:  '"ab-cd"'
#
# 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
# 
# 
# 
# 
# 
# 
# 示例 1：
# 
# 输入："ab-cd"
# 输出："dc-ba"
# 
# 
# 示例 2：
# 
# 输入："a-bC-dEf-ghIj"
# 输出："j-Ih-gfE-dCba"
# 
# 
# 示例 3：
# 
# 输入："Test1ng-Leet=code-Q!"
# 输出："Qedo1ct-eeLg=ntse-T!"
# 
# 
# 
# 
# 提示：
# 
# 
# S.length <= 100
# 33 <= S[i].ASCIIcode <= 122 
# S 中不包含 \ or "
# 
# 
#

# @lc code=start
class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        l, r, sarr = 0, len(S)-1, [c for c in S]
        while l < r:
            if sarr[l].isalpha() and sarr[r].isalpha():
                sarr[l], sarr[r] = sarr[r], sarr[l]
                l += 1; r -= 1
            else:
                if not sarr[l].isalpha(): l += 1
                if not sarr[r].isalpha(): r -= 1
        return "".join(sarr)


# @lc code=end

