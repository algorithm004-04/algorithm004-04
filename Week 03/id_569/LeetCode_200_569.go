package main

import "fmt"

var dx = [4]int{-1, 1, 0, 0}
var dy = [4]int{0, 0, 1, -1}

func main() {

	//初始化数组
	arr := [][]byte{{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 1}}

	//坐标偏移
	r := numIslands(arr)
	fmt.Printf("num is : %d ", r)
}

func numIslands(grid [][]byte) int {
	m := len(grid)
	if m == 0 {
		return 0
	}

	n := len(grid[0])
	count := 0
	for i := 0; i < m; i++ {

		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				DFS(grid, i, j)
				count++
			}
		}
	}
	return count
}

func DFS(grid [][]byte, i, j int) {
	if i < 0 || j < 0 || i >= len(grid) || j >= len(grid[0]) || grid[i][j] != 1 {
		return
	}

	grid[i][j] = 0
	for k := 0; k < 4; k++ {
		DFS(grid, i+dx[k], j+dy[k])
	}
}
