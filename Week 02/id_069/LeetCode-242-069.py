# 20191023

"""
解法1：
    暴力法
    将两个字符串进行排序，将排序前后进行比较，如果排序后一致且排序前不一致，则输出False
"""
# class Solution:
#     def isAnagram(self, s: str, t: str) -> bool:
#         if sorted(s) == sorted(t):
#                 return True
#         return False


"""
解法2：
    哈希表
    将一个字符串的所有字符放入到字典中，并将相应的value 增加1，
    将另一个字符串的所有字符放入字典中，并将相应的value 减去1,
    最后判断字典中相应index 的 value 是否都为零。
    False：有不为零的index
    True：所有index为零
"""

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        dict = {}
        for index, letter in enumerate(s):
            if letter in dict:
                dict[letter] += 1
            else:
                dict[letter] = 1
        for index, letter in enumerate(t):
            if letter in dict:
                dict[letter] -= 1
            else:
                dict[letter] = -1
        for i in dict:
            if dict[i] != 0:
                return False
        return True



s = Solution()
print(s.isAnagram('', ''))
print(s.isAnagram('a', 'a'))
print(s.isAnagram('abc', 'cba'))
print(s.isAnagram('abc', 'abc'))
