func numIslands(grid [][]byte) (ans int) {
    if len(grid) < 1 {
        return
    }
    
    for i, s := range grid {
        for j := range s {
            if grid[i][j] == '1' {
                ans++
                dfs(i, j, grid)
            }
        }
    }
    return
}

func dfs (i, j int, grid [][]byte) {
    
    if i < 0 || j < 0 || i >= len(grid) || j >= len(grid[0]) || grid[i][j] != '1' {
		return
    }
    
    grid[i][j] = '#'
    dfs(i+1, j, grid)
    dfs(i-1, j, grid)
    dfs(i, j+1, grid)
    dfs(i, j-1, grid)
}