#
# @lc app=leetcode.cn id=22 lang=python3
#
# [22] 括号生成
#
# https://leetcode-cn.com/problems/generate-parentheses/description/
#
# algorithms
# Medium (72.14%)
# Likes:    579
# Dislikes: 0
# Total Accepted:    48.5K
# Total Submissions: 67.2K
# Testcase Example:  '3'
#
# 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
# 
# 例如，给出 n = 3，生成结果为：
# 
# [
# ⁠ "((()))",
# ⁠ "(()())",
# ⁠ "(())()",
# ⁠ "()(())",
# ⁠ "()()()"
# ]
# 
# 
#

# @lc code=start
class Solution:
    def generateParenthesis(self, n: int) -> [str]:
        length, res = 2*n, []
        def helper(s:str, lc:int, rc:int):
            if len(s) == length:
                res.append(s)
                return
            if lc < n: helper(s+"(", lc+1, rc)
            if rc < lc: helper(s+")", lc, rc + 1)
        helper("", 0, 0)
        return res

# Improved version of this. Parameter open tells the number of “already opened” parentheses, and I continue the recursion as long as I still have to open parentheses (n > 0) and I haven’t made a mistake yet (open >= 0).
    # def generateParenthesis(self, n, open=0):
    #     if n > 0 <= open:
    #         return ['(' + p for p in self.generateParenthesis(n-1, open+1)] + \
    #             [')' + p for p in self.generateParenthesis(n, open-1)]
    #     return [')' * open] * (not n)

# @lc code=end

