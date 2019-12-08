# -*- coding: utf8 -*-

"""
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:
2:"abc"
3:"def"
4:"ghi"
5:"jkl"
6:"mno"
7:"pqrs"
8:"tuv"
9:"wxyz"
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
"""

class Solution(object):

    def __init__(self):
        self.map = {
            '2': "abc",
            '3': "def",
            '4': "ghi",
            '5': "jkl",
            '6': "mno",
            '7': "pqrs",
            '8': "tuv",
            '9': "wxyz"
        }
        self.res = []
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """

        if digits:
            self.helper("",digits)
        return self.res

    def helper(self,s,next_digit):
        """
        :param i:
        :param n:
        :param letter:
        :return:
        """
        if len(next_digit) == 0:
            self.res.append(s)
            return s
        for letter in self.map[next_digit[0]]:
            self.helper(s + letter,next_digit[1:])




if __name__ == '__main__':
    slt = Solution()
    digits = "23"
    print(slt.letterCombinations(digits))