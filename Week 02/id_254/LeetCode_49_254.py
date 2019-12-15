import collections
class Solution:
    def groupAnagrams(self, strs):
        ans = collections.defaultdict(list)
        for st in strs:
            ans[tuple(sorted(st))].append(st)
        return ans.values()
