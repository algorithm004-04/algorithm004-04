/*
 * @lc app=leetcode.cn id=94 lang=golang
 *
 * [590] n叉树的后序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Children []*TreeNode
 * }
 */

 func postOrderTraversal(root *TreeNode) []int {
	res := []int{}
	for _, v := range root.Children {
		child := postOrderTraversal(v)
		res = append(res, child...)
	}
	res = append(res, root.Val)
	return res
}
// @lc code=end

