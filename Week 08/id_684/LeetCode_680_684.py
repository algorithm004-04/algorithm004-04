# -*- coding: utf8 -*-


"""
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

示例 1:

输入: "aba"
输出: True
示例 2:

输入: "abca"
输出: True
解释: 你可以删除c字符。
注意:

字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
"""


class Solution(object):
    def validPalindrome(self, s):
        """
        暴力，超时
        :type s: str
        :rtype: bool
        """
        length = len(s)
        for i in range(length):
            ds = s[:i] + s[i + 1:]
            if ds == ds[::-1]:
                return True
        return False

    def validPalindrome2(self, s):
        """
        双指针 超时
        :type s: str
        :rtype: bool
        """
        length = len(s)
        i = 0
        j = length - 1
        count = 0
        while i < j:
            if s[i] == s[j]:
                i += 1
                j -= 1
            if s[i] != s[j]:
                if s[i + 1] == s[j]:
                    count += 1
                    i += 1
                if s[i] == s[j - 1]:
                    count += 1
                    j -= 1
            if count > 1: return False
        return True

    def validPalindrome3(self, s):
        """
        双指针优化
        :type s: str
        :rtype: bool
        """
        length = len(s)
        i = 0
        j = length - 1
        while i < j:
            if s[i] == s[j]:
                i += 1
                j -= 1
            if s[i] != s[j]:
                a = s[i + 1: j + 1]
                # 舍弃右字符
                b = s[i:j]
                return a[::-1] == a or b[::-1] == b
        return True


if __name__ == '__main__':
    slt = Solution()
    s = "abca"
    print(slt.validPalindrome3(s))
