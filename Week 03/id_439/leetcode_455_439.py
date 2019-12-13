class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        child = 0
        cookie = 0
        g.sort()
        s.sort()
        while ((child < len(g)) and (cookie < len(s))):
            if (g[child] <= s[cookie]):
                child = child + 1
            cookie = cookie + 1
        return child