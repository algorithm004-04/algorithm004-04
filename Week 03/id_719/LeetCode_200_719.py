# DFS
def numIslands(grid):
    if not grid:
        return 0
    row = len(grid)
    col = len(grid[0])
    cnt = 0

    def dfs(i, j):
        grid[i][j] = "0"
        for x, y in [[-1, 0], [1, 0], [0, -1], [0, 1]]:
            tmp_i = i + x
            tmp_j = j + y
            if 0 <= tmp_i < row and 0 <= tmp_j < col and grid[tmp_i][tmp_j] == "1":
                dfs(tmp_i, tmp_j)

    for i in range(row):
        for j in range(col):
            if grid[i][j] == "1":
                dfs(i, j)
                cnt += 1

    return cnt


s = [["1", "1", "0", "0", "0"], ["1", "1", "0", "0", "0"],
     ["0", "0", "1", "0", "0"], ["0", "0", "0", "1", "1"]]
print(numIslands(s))


# BFS
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        from collections import deque
        if not grid:
            return 0
        row = len(grid)
        col = len(grid[0])
        cnt = 0

        def bfs(i, j):
            queue = deque()
            queue.appendleft((i, j))
            grid[i][j] = "0"
            while queue:
                i, j = queue.pop()
                for x, y in [[-1, 0], [1, 0], [0, -1], [0, 1]]:
                    tmp_i = i + x
                    tmp_j = j + y
                    if 0 <= tmp_i < row and 0 <= tmp_j < col and grid[tmp_i][tmp_j] == "1":
                        grid[tmp_i][tmp_j] = "0"
                        queue.appendleft((tmp_i, tmp_j))

        for i in range(row):
            for j in range(col):
                if grid[i][j] == "1":
                    bfs(i, j)
                    cnt += 1
        return cnt
