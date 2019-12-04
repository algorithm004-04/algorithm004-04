/*
 * @lc app=leetcode.cn id=94 lang=golang
 *
 * [589] n叉树的前遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Children []*TreeNode
 * }
 */

 func preOrderTraversal(root *TreeNode) []int {
	res := []int{root.Val}
	for _, v := range root.Children {
		child := preOrderTraversal(v)
		res = append(res, child...)
	}
	return res
}
// @lc code=end

