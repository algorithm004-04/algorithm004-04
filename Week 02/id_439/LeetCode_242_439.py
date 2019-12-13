#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        return collections.Counter(s) == collections.Counter(t)

# @lc code=start
class Solution:
    def isAnagram2(self, s: str, t: str) -> bool:
        dic = {}
        for i in s:
            if i not in dic:
                dic[i] = 1
            else:
                dic[i] += 1
        
        for j in t:
            if j not in dic:
                return False
            else:
                dic[j] -=1
        
        for val in dic.values():
            if val != 0:
                return False
        
        return True

    def isAnagram(self, s: str, t: str) -> bool:
        dic1, dic2 = {}, {}
        for i in s:
            dic1[i] = dic1.get(i, 0) + 1
        for i in t:
            dic2[i] = dic2.get(i, 0) + 1
        return dic1 == dic2
# @lc code=end
