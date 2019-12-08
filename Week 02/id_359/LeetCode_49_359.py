# 49. 字母异位词分组
# https://leetcode-cn.com/problems/group-anagrams/
# possible solution: key排序+hash
# test case: empty, one element, multi unique element

class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        mapp = {}
        for s in strs:
            key = ''.join(sorted(s))
            if key in mapp:
                mapp[key].append(s)
            else:
                mapp[key] = [s]
        return [i for i in mapp.values()]
