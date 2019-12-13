/*
 * @lc app=leetcode id=547 lang=golang
 *
 * [547] Friend Circles
 *
 * https://leetcode.com/problems/friend-circles/description/
 *
 * algorithms
 * Medium (54.96%)
 * Likes:    1329
 * Dislikes: 105
 * Total Accepted:    117K
 * Total Submissions: 209.3K
 * Testcase Example:  '[[1,1,0],[1,1,0],[0,0,1]]'
 *
 *
 * There are N students in a class. Some of them are friends, while some are
 * not. Their friendship is transitive in nature. For example, if A is a direct
 * friend of B, and B is a direct friend of C, then A is an indirect friend of
 * C. And we defined a friend circle is a group of students who are direct or
 * indirect friends.
 *
 *
 *
 * Given a N*N matrix M representing the friend relationship between students
 * in the class. If M[i][j] = 1, then the ith and jth students are direct
 * friends with each other, otherwise not. And you have to output the total
 * number of friend circles among all the students.
 *
 *
 * Example 1:
 *
 * Input:
 * [[1,1,0],
 * ⁠[1,1,0],
 * ⁠[0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a
 * friend circle. The 2nd student himself is in a friend circle. So return
 * 2.
 *
 *
 *
 * Example 2:
 *
 * Input:
 * [[1,1,0],
 * ⁠[1,1,1],
 * ⁠[0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd
 * students are direct friends, so the 0th and 2nd students are indirect
 * friends. All of them are in the same friend circle, so return 1.
 *
 *
 *
 *
 * Note:
 *
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 *
 *
 */

// @lc code=start
// v1, DFS
func findCircleNum(M [][]int) int {
	visited := make([]int, len(M))
	count := 0
	for i := 0; i < len(M); i++ {
		if visited[i] == 0 {
			dfs(M, visited, i)
			count++
		}
	}
	return count
}

func dfs(M [][]int, visited []int, i int) {
	for j := 0; j < len(M); j++ {
		if M[i][j] == 1 && visited[j] == 0 {
			visited[j] = 1
			dfs(M, visited, j)
		}
	}
}

// v2, BFS
func findCircleNum(M [][]int) int {
	visited := make([]int, len(M))
	count := 0
	queue := []int{}
	for i := 0; i < len(M); i++ {
		if visited[i] == 0 {
			queue = append(queue, i)
			for len(queue) > 0 {
				cur := queue[0]
				queue = queue[1:]
				visited[cur] = 1
				for j := 0; j < len(M); j++ {
					if M[cur][j] == 1 && visited[j] == 0 {
						queue = append(queue, j)
					}
				}
			}
			count++
		}
	}

	return count
}

// v3, disjoint set
/*
a. N --> 各自独立集合
b. 遍历好友关系矩阵 M：M[i][j] --> 合并
c. 有多少独立的集合
*/
func findCircleNum(M [][]int) int {
	// init M
	parent := make([]int, len(M))
	for i := 0; i < len(M); i++ {
		parent[i] = -1
	}
	// disjoint set
	for i := 0; i < len(M); i++ {
		for j := 0; j < len(M); j++ {
			if M[i][j] == 1 && i != j {
				union(parent, i, j)
			}
		}
	}
	// count num
	count := 0
	for i := 0; i < len(parent); i++ {
		if parent[i] == -1 {
			count++
		}
	}
	return count
}

func find(parent []int, i int) int {
	if parent[i] == -1 {
		return i
	}
	return find(parent, parent[i])
}

func union(parent []int, i, j int) {
	xset, yset := find(parent, i), find(parent, j)
	if xset != yset {
		parent[xset] = yset
	}
}

// @lc code=end

