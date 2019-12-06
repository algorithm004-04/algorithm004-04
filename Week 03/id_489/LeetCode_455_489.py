from typing import List
class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        res = 0
        g.sort()
        s.sort()
        g_length = len(g)
        s_length = len(s)
        i, j = 0, 0
        while i < g_length and j < s_length:
            if g[i] <= s[j]:
                res += 1
                i += 1
                j += 1
            else:
                j += 1
        return res


if __name__ == '__main__':
    solution = Solution()
    print(solution.findContentChildren([1, 2, 3], [1, 1]))