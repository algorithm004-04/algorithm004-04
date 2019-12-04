# -*- coding: utf8 -*-

"""
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。


什么是字母异位词？两个单词包含相同的字母，但是次序不同

"""

class Solution(object):
    def isAnagram(self, s, t):
        """
        排序，时间复杂度O(nlogn)
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):return False
        return sorted(s) == sorted(t)

    def isAnagram2(self, s, t):
        """
        哈希表时间复杂度O(n)
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):return False
        map = {}
        for i in s:
            if i in map:
                map[i] = map[i] + 1
            else:
                map[i] = 1
        for j in t:
            if j in map:
                map[j] = map[j] - 1
            else:
                map[j] = 1
        for v in map.values():
            if v > 0:return False
        return True


if __name__ == '__main__':
    s = "anagrams"
    t = "nagaramf"
    slt = Solution()
    print(slt.isAnagram2(s,t))