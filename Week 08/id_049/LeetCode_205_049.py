class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        res = {}
        for i, v in enumerate(s):
            if res.get(v):
                if t[i] != res[v]:
                    return False
            else:
                if t[i] in res.values():
                    return False
                res[v] = t[i]
        return True