#1.深度优先遍历：采用递归
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
                    t = (i, j)
                    self.xun(t)
        return res
    
    def xun(self, t):
        x, y = t
        if self.grid[x][y] == '1':
            self.grid[x][y] = '0'
            if x + 1 < len(self.grid):
                self.xun((x + 1, y))
            if y + 1 < len(self.grid[0]):
                self.xun((x, y + 1))
            if x - 1 >= 0:
                self.xun((x - 1, y))
            if y - 1 >= 0:
                self.xun((x, y - 1))
        else:
            return
                    
#2.广度优先遍历 采用队列
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
