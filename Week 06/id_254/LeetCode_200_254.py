class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
      f = {}

      def find(x):
        f.setdefault(x, x)
        if f[x] != x:
          f[x] = find(f[x])
        return f[x]

      def union(x, y):
        f[find(x)] = find(y)

      if not grid:
          return 0
      row = len(grid)
      col = len(grid[0])

      for i in range(row):
        for j in range(col):
          if grid[i][j] == '1':
            for x, y in [[1, 0], [0, 1]]:
              temp_i = i + x
              temp_j = j + y
              if 0 <= temp_i < row and 0 <= temp_j < col and grid[temp_i][temp_j] == '1':
                union(temp_i*row+temp_j, i*row+j)

      res = set()
      for i in range(row):
        for j in range(col):
          if grid[i][j] == '1':
            res.add(find(i*row+j))
      return len(res)
