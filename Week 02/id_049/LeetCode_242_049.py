class Solution:
    def isAnagramHash(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        s_hash = {}
        t_hash = {}
        for i in s:
            s_hash[i] = s_hash.get(i, 0)+1
        for i in t:
            t_hash[i] = t_hash.get(i, 0)+1
        return s_hash == t_hash

    def isAnagramArray(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        s_array = [0]*26
        t_array = [0]*26
        for i in s:
            s_array[ord(i)-ord("a")] += 1
        for i in t:
            t_array[ord(i)-ord("a")] += 1
        return s_array == t_array
