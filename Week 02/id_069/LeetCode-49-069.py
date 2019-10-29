# 20191023

"""
1. 将列表中的字符串进行排序
2. 查看排序后的字符串是否在字典内，不在则新增一个列表，如果在就append进去
3. 将字典的value进行输出
"""

class Solution:
    def groupAnagrams(self, strs):
        dict = {}
        for value in strs:
            key = ''.join(sorted(value))
            if key in dict:
                dict[key].append(value)
            else:
                dict[key] = [value]
        return dict.values()


s = Solution()
print(s.groupAnagrams(['abc', 'cdf', 'bca']))

        