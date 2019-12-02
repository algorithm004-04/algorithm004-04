class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        self.grid = grid
        res = 0
        if not self.grid:
            return res
        for i, m in enumerate(self.grid):
            for j, n in enumerate(m):
                if n == '1':
                    res += 1
                    q = [(i, j)]
                    while q:
                        x, y = q.pop()
                        if self.grid[x][y] == '1':
                            self.grid[x][y] = '0'
                            if x + 1 < len(self.grid):
                                q.append((x + 1, y))
                            if y + 1 < len(self.grid[0]):
                                q.append((x, y + 1))
                            if x - 1 >= 0:
                                q.append((x - 1, y))
                            if y - 1 >= 0:
                                q.append((x, y - 1))   
        return res
