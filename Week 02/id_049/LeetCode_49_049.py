class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        ans = collections.defaultdict(list)
        for i in strs:
            ans[tuple(sorted(i))].append(i)
        return ans.values()