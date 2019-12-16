class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        sm = {}
        tm = {}
        for i in s:
            if i not in sm:
                sm[i] = s.count(i)
        for j in t:
            if j not in tm:
                tm[j] = t.count(j)
        return sm == tm

