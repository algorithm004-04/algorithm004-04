class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def flood_fill(i, j): 
            if grid[i][j] == '1':  
                grid[i][j] = '0'
                flood_fill(i-1, j) 
                flood_fill(i+1, j)
                flood_fill(i, j-1)
                flood_fill(i, j+1)
        
        if not grid: return 0 
        grid = [['0'] + row + ['0'] for row in grid]  
        grid = [['0'] * len(grid[0])] + grid + [['0'] * len(grid[0])] 
        m, n = len(grid), len(grid[0]) 
        count = 0 
        for i in range(1, m-1):
            for j in range(1, n-1):
                if grid[i][j] == '1': 
                    count += 1 
                flood_fill(i, j)  
        return count