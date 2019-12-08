# coding=utf-8

"""
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true

示例 2:

输入: s = "rat", t = "car"
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-anagram
"""


class Solution:
    # 方法一：
    #       遍历s，得到字符和次数的对应表
    #       通过比较s, t的字符种类和出现的次数
    # N: 字符串最大长度
    # 时间复杂度：O(N)，两个并列循环O(N)
    # 空间复杂度：O(N)
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        elif s == t:
            return True
        chr2count_s = {}
        chr2count_t = {}
        for char in s:
            chr2count_s[char] = chr2count_s.get(char, 0) + 1
        for char in t:
            chr2count_t[char] = chr2count_t.get(char, 0) + 1
        if len(chr2count_t) != len(chr2count_s):
            return False
        return chr2count_t == chr2count_s

    # 与方法一思路相同，代码精简
    # `set去重` 和 长度判断 提高效率
    # * 目前实际表现效率最好
    # TODO: count()和set()的内部实现？
    def is_anagram_2(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        elif s == t:
            return True
        s_str = set(s)
        t_str = set(t)
        if len(s_str) != len(t_str):
            return False
        for i in s_str:
            if s.count(i) != t.count(i):
                return False
        return True

    # 方法二：
    #       将s, t都进行排序, 如果s和t值相等，则两者符合条件
    # 但是这个需要了解sorted()内置函数的时间复杂度, 主要时间花费在排序上
    # 时间复杂度：O(NlogN)，内循环字符串排序O(NlogN)
    # 空间复杂度：O(N)
    def is_anagram_3(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        elif s == t:
            return True
        return sorted(s) == sorted(t)

    # 方法三：
    #       字母计数
    # 时间复杂度：O(N)
    # 空间复杂度：O(1)
    def is_anagram_4(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        elif s == t:
            return True
        alpha_count = [0] * 26
        for i in range(len(s)):
            alpha_count[ord(s[i]) - ord('a')] += 1
            alpha_count[ord(t[i]) - ord('a')] -= 1
        return len(list(filter(lambda x: x != 0, alpha_count))) == 0
