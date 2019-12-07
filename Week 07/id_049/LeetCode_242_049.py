class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        s_hash = {}
        t_hash = {}
        for i in s:
            s_hash[i] = s_hash.get(i, 0)+1
        for j in s:
            t_hash[j] = t_hash.get(j, 0)+1
        return s_hash == t_hash
