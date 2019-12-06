/*
 * @lc app=leetcode.cn id=200 lang=golang
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (45.64%)
 * Likes:    276
 * Dislikes: 0
 * Total Accepted:    38.4K
 * Total Submissions: 83.9K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给定一个由 '1'（陆地）和
 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 
 * 示例 1:
 * 
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * 输出: 3
 * 
 * 
 */

// @lc code=start
func numIslands(grid [][]byte) int {
	if len(grid) == 0 {
		return 0
	}

	m := len(grid)
	n := len(grid[0])
	u := newUnionFind(grid)
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == '1' {
				grid[i][j] = '0'
				if i-1 >= 0 && grid[i-1][j] == '1' {
					u.union(i*n+j, (i-1)*n+j)
				}
				if i+1 < m && grid[i+1][j] == '1' {
					u.union(i*n+j, (i+1)*n+j)
				}
				if j-1 >= 0 && grid[i][j-1] == '1' {
					u.union(i*n+j, i*n+j-1)
				}
				if j+1 < n && grid[i][j+1] == '1' {
					u.union(i*n+j, i*n+j+1)
				}
			}
		}
	}
	return u.getCount()
}

type unionFind struct {
	parent []int
	rank   []int
	count  int
}

func newUnionFind(grid [][]byte) *unionFind {
	u := new(unionFind)
	m := len(grid)
	n := len(grid[0])
	u.parent = make([]int, m*n)
	u.rank = make([]int, m*n)
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == '1' {
				u.parent[i*n+j] = i*n + j
				u.count++
			}
			u.rank[i*n+j] = 0
		}
	}
	return u
}

func (u *unionFind) find(i int) int {
	if u.parent[i] != i {
		u.parent[i] = u.find(u.parent[i])
	}
	return u.parent[i]
}

func (u *unionFind) getCount() int {
	return u.count
}

func (u *unionFind) union(x, y int) {
	rootX := u.find(x)
	rootY := u.find(y)
	if rootX != rootY {
		if u.rank[rootX] > u.rank[rootY] {
			u.parent[rootY] = rootX
		} else if u.rank[rootX] < u.rank[rootY] {
			u.parent[rootX] = rootY
		} else {
			u.parent[rootY] = rootX
			u.rank[rootX]++
		}
		u.count--
	}
}

// @lc code=end



