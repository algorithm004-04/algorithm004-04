#
# @lc app=leetcode id=49 lang=python3
#
# [49] Group Anagrams
#

# @lc code=start
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        return self.groupAnagrams2(strs)
    
    def groupAnagrams1(self, strs: List[str]) -> List[List[str]]:
        dict = {}
        for item in strs:
            sortedItem = ''.join(sorted(item))
            dict[sortedItem] = dict.get(sortedItem, []) + [item]
        return dict.values()

    def groupAnagrams2(self, strs: List[str]) -> List[List[str]]:
        dict = {}
        for item in strs:
            key = tuple(sorted(item))
            dict[key] = dict.get(key, []) + [item]
        return dict.values()
        
# @lc code=end

