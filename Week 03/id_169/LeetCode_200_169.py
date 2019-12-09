from typing import List


class Solution:
    dx = [0, 1, 0, -1]
    dy = [-1, 0, 1, 0]
    g = []

    def numIslands(self, grid: List[List[str]]) -> int:
        islands = 0
        self.g = grid
        for i in range(len(self.g)):
            for j in range(len(self.g[i])):
                if self.g[i][j] == "0": continue
                islands += self.sink(i, j)
        return islands

    def sink(self, i, j):
        if self.g[i][j] == "0": return 0
        self.g[i][j] = "0"
        for k in range(len(self.dx)):
            x, y = i + self.dx[k], j + self.dy[k]
            if 0 <= x < len(self.g) and 0 <= y < len(self.g[i]):
                if self.g[x][y] == "0": continue
                self.sink(x, y)
        return 1
