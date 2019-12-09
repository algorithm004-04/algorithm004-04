class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0

        def sink(i, j, grid):
            if not 0 <= i < len(grid) or not 0 <= j < len(grid[0]) or grid[i][j] == "0":
                return
            grid[i][j] = "0"
            sink(i+1, j, grid)
            sink(i, j+1, grid)
            sink(i-1, j, grid)
            sink(i, j-1, grid)

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    sink(i, j, grid)
                    count += 1
        return count
