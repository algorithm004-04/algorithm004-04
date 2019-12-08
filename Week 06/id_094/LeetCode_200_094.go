func numIslands(grid [][]byte) int {
	visited := make([][]bool, len(grid))
	for i := range visited {
		visited[i] = make([]bool, len(grid[i]))
	}
	result := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == '1' && !visited[i][j] {
				result++
				bfs(grid, i, j, visited)
			}
		}
	}
	return result
}

func bfs(grid [][]byte, i int, j int, visited [][]bool) {
	var queue []Queue
	queue = append(queue, Queue{i, j})
	for len(queue) > 0 {
		head := queue[0]
		row := head.Row
		col := head.Col
		queue = queue[1:]
		if grid[row][col] == '1' && !visited[row][col] {
			visited[row][col] = true
			if row-1 >= 0 {
				queue = append(queue, Queue{row - 1, col})
			}
			if row+1 < len(grid) {
				queue = append(queue, Queue{row + 1, col})
			}
			if col-1 >= 0 {
				queue = append(queue, Queue{row, col - 1})
			}
			if col+1 < len(grid[0]) {
				queue = append(queue, Queue{row, col + 1})
			}
		}
	}
}

type Queue struct {
	Row int
	Col int
}