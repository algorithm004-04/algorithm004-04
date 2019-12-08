/*
 * @lc app=leetcode.cn id=547 lang=golang
 *
 * [547] 朋友圈
 *
 * https://leetcode-cn.com/problems/friend-circles/description/
 *
 * algorithms
 * Medium (52.24%)
 * Likes:    149
 * Dislikes: 0
 * Total Accepted:    18K
 * Total Submissions: 33.7K
 * Testcase Example:  '[[1,1,0],[1,1,0],[0,0,1]]'
 *
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是
 * C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * 
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j
 * 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 
 * [[1,1,0],
 * ⁠[1,1,0],
 * ⁠[0,0,1]]
 * 输出: 2 
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: 
 * [[1,1,0],
 * ⁠[1,1,1],
 * ⁠[0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * 
 * 
 * 注意：
 * 
 * 
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 * 
 * 
 */

// @lc code=start
func findCircleNum(M [][]int) int {
	n := len(M)
	u := newUnion(n)
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if M[i][j] == 1 && i != j {
				u.union(i, j)
			}
		}
	}
	return u.count
}

type unionFind struct {
	parent []int
	count int
}

func newUnion(n int) *unionFind {
	u := new(unionFind)
	u.parent = make([]int, n)
	u.count = n
	for i := 0; i < n; i++ {
		u.parent[i] = -1
	}
	return u
}

func (u *unionFind) find(i int) int {
	if u.parent[i] == -1 {
		return i
	}
	return u.find(u.parent[i])
}

func (u *unionFind) union(x,y int) {
	rootX := u.find(x)
	rootY := u.find(y)
	if rootX != rootY {
		u.parent[rootX] = rootY
		u.count--
	}
}
// @lc code=end

