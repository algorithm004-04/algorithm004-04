# 20191102

# Done

"""
1. 排序
2. 先满足胃口较小的孩子
"""
class Solution:
    def findContentChildren(self, g, s):
        res = 0
        g.sort()
        s.sort()

        g_length = len(g)
        s_length = len(s)

        i = 0
        j = 0
        while i < g_length and j < s_length:
            if g[i] <= s[j]:
                res += 1
                i += 1
            j += 1
        
        return res


s = Solution()
print(s.findContentChildren([1, 2, 3], [1, 1, 3]))