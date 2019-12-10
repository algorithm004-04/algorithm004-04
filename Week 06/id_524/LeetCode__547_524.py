#!/usr/bin/env python
#-*-coding:utf-8-*-
# author:lwz


class Solution(object):
    def findCircleNum(self, M):
        N, visited, res = len(M), set(), 0
        for i in range(N):
            if i not in visited:
                queue = [i]
                while queue:
                    p = queue.pop(0)
                    if p not in visited:
                        visited.add(p)
                        queue += [k for k, num in enumerate(M[p]) if num and k not in visited]
                res += 1
        return res

M = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]
solution = Solution()
solution.findCircleNum(M)
