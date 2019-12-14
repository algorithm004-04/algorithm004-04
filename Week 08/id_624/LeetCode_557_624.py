#
# @lc app=leetcode.cn id=557 lang=python3
#
# [557] 反转字符串中的单词 III
#
# https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/description/
#
# algorithms
# Easy (67.99%)
# Likes:    131
# Dislikes: 0
# Total Accepted:    34.9K
# Total Submissions: 51K
# Testcase Example:  '"Let\'s take LeetCode contest"'
#
# 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
# 
# 示例 1:
# 
# 
# 输入: "Let's take LeetCode contest"
# 输出: "s'teL ekat edoCteeL tsetnoc" 
# 
# 
# 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
# 
#

# @lc code=start
class Solution:
    def reverseWords(self, s: str) -> str:
        res, temp = "", ""
        for i in range(len(s)):
            if s[i] == " ":
                res += temp[::-1] + " "
                temp = ""
            else: temp += s[i]
        res += temp[::-1]
        return res
    # def reverseWords(self, s: str) -> str:
    #     stack, res, s = [], "", s+" "
    #     for c in s:
    #         stack.append(c)
    #         if c == " ":
    #             while stack: res += stack.pop()
    #     return res[1:]



# @lc code=end

