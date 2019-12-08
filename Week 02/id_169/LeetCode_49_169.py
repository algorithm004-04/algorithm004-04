from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        """
        利用一个map来存储分组结果，map的key为每个字符串的排序值，value为字符串列表
        {
            "abc": ["acb", "bca", "cba"]
        }
        """
        map = {}
        for s in strs:
            key = ''.join(sorted(s))
            if key in map: map[key].append(s)
            else: map[key] = [s]
        return list(map.values())


print(Solution().groupAnagrams(["eat","tea","tan","ate","nat","bat"]))
