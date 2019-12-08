#
# @lc app=leetcode.cn id=17 lang=python3
#
# [17] 电话号码的字母组合
#
# https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
#
# algorithms
# Medium (51.15%)
# Likes:    479
# Dislikes: 0
# Total Accepted:    53K
# Total Submissions: 103.4K
# Testcase Example:  '"23"'
#
# 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
#
# 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
#
#
#
# 示例:
#
# 输入："23"
# 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
#
#
# 说明:
# 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
#
#

# @lc code=start


class Solution:
    # 该题目是括号组合的泛化问题。思路就是：对于第一个数字对应的每个字母，只要与剩下数字对应字母的所有组合分别组合，就可以完成所有可能的组合了。
    def letterCombinations(self, digits: str) -> [str]:
        if not digits: return []
        dic = {"2": "abc", "3": "def", "4": "ghi", "5": "jkl",
               "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"}
        def backtrace(combination="", nextDigits=digits):
            if not nextDigits:
                res.append(combination)
                return
            for c in dic[nextDigits[0]]:
                backtrace(combination+c, nextDigits[1:])
        res = []
        backtrace()
        return res    

# Solution().letterCombinations("")
# @lc code=end
