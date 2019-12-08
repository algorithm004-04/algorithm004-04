class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        from collections import defaultdict
        a = defaultdict(list)
        for s in strs:
            m = [0] * 26
            for i in s:
                m[ord(i) - ord('a')] = s.count(i)
            a[tuple(m)].append(s)
        return a.values()
