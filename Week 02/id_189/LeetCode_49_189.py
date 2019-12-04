#
# @lc app=leetcode.cn id=49 lang=python
#
# [49] 字母异位词分组
#

# 1. 维护一个映射 key = sorted(str), value = list of strs

# @lc code=start
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        
        d = collections.defaultdict(list)

        for s in strs:
            d[tuple(sorted(s))].append(s)

        return d.values()

# @lc code=end

