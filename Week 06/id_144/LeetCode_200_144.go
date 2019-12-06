/*
 * @lc app=leetcode id=200 lang=golang
 *
 * [200] Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (42.77%)
 * Likes:    3421
 * Dislikes: 125
 * Total Accepted:    461.8K
 * Total Submissions: 1.1M
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 *
 * Example 1:
 *
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 *
 *
 * Example 2:
 *
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 *
 */

// @lc code=start
// v1, brute force
// 沉岛法：又称“flood fill”，遍历所有点，每次遇到1，就把它周围（水平或竖直方向相邻）的1变为0，直到整片地图都为0，看总共沉岛了多少次，即为岛的个数
var g [][]byte
var dx []int
var dy []int

func numIslands(grid [][]byte) int {
	g = grid
	dx = []int{-1, 1, 0, 0}
	dy = []int{0, 0, -1, 1}
	num := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == '1' {
				sink(i, j)
				num++
			}
		}
	}
	return num
}

func sink(i, j int) {
	// terminator
	if i < 0 || i >= len(g) || j < 0 || j >= len(g[0]) || g[i][j] == '0' {
		return
	}
	// current logic
	g[i][j] = '0'

	// drill down
	for k := 0; k < len(dx); k++ {
		x, y := i+dx[k], j+dy[k]
		sink(x, y)
	}
}

// v2, disjoint-set
var count int

func numIslands(grid [][]byte) int {
	g := grid
	dx, dy := []int{1, 0, -1, 0}, []int{0, 1, 0, -1}

	row := len(g)
	if row == 0 {
		return 0
	}
	col := len(g[0])
	parent := make([]int, row*col)
	count = 0

	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			if g[i][j] == '1' {
				parent[i*col+j] = i*col + j
				count++
			}
		}
	}

	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			if g[i][j] == '1' {
				for k := 0; k < len(dx); k++ {
					tmpX, tmpY := i+dx[k], j+dy[k]
					if tmpX >= 0 && tmpX < row && tmpY >= 0 && tmpY < col && grid[tmpX][tmpY] == '1' {
						unionIsland(tmpX*col+tmpY, i*col+j, parent)
					}
				}
			}
		}
	}

	return count
}

func unionIsland(i, j int, parent []int) {
	xset, yset := findIsland(i, parent), findIsland(j, parent)
	if xset != yset {
		parent[xset] = yset
		count--
	}
}

func findIsland(i int, parent []int) int {
	if parent[i] == i {
		return i
	}
	return findIsland(parent[i], parent)
}

// @lc code=end

