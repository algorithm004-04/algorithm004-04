# -*- coding: utf8 -*-


"""
给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。

示例:

输入: s = "abcdefg", k = 2
输出: "bacdfeg"
要求:

该字符串只包含小写的英文字母。
给定字符串的长度和 k 在[1, 10000]范围内。

"""


class Solution(object):
    def reverseStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        length = len(s)
        if k > length:
            return "".join(reversed([x for x in s]))
        res = ""
        s = [x for x in s]
        for i in range(0, length, 2 * k):
            if len(s[i:]) < k and len(s[i:]) > 0:
                res += ''.join(reversed(s[i:]))
            elif len(s[i:]) > k and len(s[i:]) < 2 * k:
                res += ''.join(reversed(s[i:i + k]))
                res += ''.join(s[i + k:])
            else:
                res += ''.join(reversed(s[i:i + k]))
                res += ''.join(s[i + k:i + 2 * k])
        return res

    def reverseStr2(self, s, k):
        a = list(s)
        for i in range(0, len(a), 2 * k):
            a[i:i + k] = reversed(a[i:i + k])
        return "".join(a)


if __name__ == '__main__':
    slt = Solution()
    s = "abcdefg"
    k = 8
    print(slt.reverseStr2(s, k))
