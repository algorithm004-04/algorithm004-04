#
# @lc app=leetcode.cn id=242 lang=python
#
# [242] 有效的字母异位词
#

# 1. 排序
# 2019.10.24 通过。


# class Solution(object):
#     def isAnagram(self, s, t):
#         """
#         :type s: str
#         :type t: str
#         :rtype: bool
#         """

#         # 对 s 和 t 按字母顺序排序

#         s = ''.join(sorted(s))
#         t = ''.join(sorted(t))

#         return s == t


# 2. 哈希法。
# 2019.10.24 通过。


# class Solution(object):
#     def isAnagram(self, s, t):
#         """
#         :type s: str
#         :type t: str
#         :rtype: bool
#         """

#         dict_s, dict_t = {}, {}

#         for char in s:
#             dict_s[char] = dict_s.get(char,0) + 1
#         for char in t:
#             dict_t[char] = dict_t.get(char,0) + 1
        
#         return dict_s == dict_t



# 3. 哈希法。用 26 个 0 的 list 统计每个字母。
# 2019.10.24 通过。

# @lc code=start
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        d = [0] * 26

        for char in s:
            d[ord(char)-97] += 1
        
        for char in t:
            d[ord(char)-97] -= 1
            if d[ord(char)-97] < 0: 
                return False

        if sum(d) > 0 : 
            return False
        else: 
            return True

# @lc code=end