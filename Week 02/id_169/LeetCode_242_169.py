class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        """
        HashMap
        """
        smap, tmap = {}, {}
        for c in s:
            if c in smap: smap[c] += 1
            else: smap[c] = 1
        for c in t:
            if c in tmap: tmap[c] += 1
            else: tmap[c] = 1
        for c in smap:
            if c not in tmap: return False
            if smap[c] != tmap[c]: return False
            del tmap[c]
        return len(tmap) == 0


print(Solution().isAnagram('anagram', 'nagaram'))
