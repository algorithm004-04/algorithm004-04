class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
      """
      :type M: List[List[int]]
      :rtype: int
      """
      n = len(M)
      digjoin = {i: {i} for i in range(n)}
      res = n
      for i in range(n):
        for j in range(i, n):
          if i != j and M[i][j] == 1 and digjoin[i] is not digjoin[j]:
            digjoin[i] |= digjoin[j]
            for k in digjoin[j]:
              digjoin[k] = digjoin[i]
            res -= 1
      return res
