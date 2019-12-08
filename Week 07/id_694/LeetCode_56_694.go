/*
 * @lc app=leetcode.cn id=56 lang=golang
 *
 * [56] 合并区间
 *
 * https://leetcode-cn.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (38.88%)
 * Likes:    218
 * Dislikes: 0
 * Total Accepted:    39.6K
 * Total Submissions: 100.8K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 
 * 示例 2:
 * 
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 */

// @lc code=start
func merge(intervals [][]int) [][]int {
	inter := ints(intervals)
	sort.Sort(inter)
	res := make([][]int, 0)

	for _, v := range intervals {
		ll := len(res)
		if ll == 0 || res[ll-1][1] < v[0] {
			res = append(res, v)
		} else {
			if res[ll-1][1] < v[1] {
				res[ll-1][1] = v[1]
			}
		}
	}

	return res
}

type ints [][]int

func (t ints) Len() int {
	return len(t)
}

func (t ints) Less(i, j int) bool {
	return t[i][0] < t[j][0]
}

func (t ints) Swap(i, j int) {
	t[i], t[j] = t[j], t[i]
}
// @lc code=end

