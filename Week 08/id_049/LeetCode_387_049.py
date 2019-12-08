class Solution:
    def firstUniqChar(self, s: str) -> int:
        s_hash = {}
        for i in s:
            s_hash[i] = s_hash.get(i,0)+1
        for i, v in enumerate(s):
            if s_hash[v] == 1:
                return i
        return -1