/*
 * @lc app=leetcode id=104 lang=golang
 *
 * [104] Maximum Depth of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func maxDepth(root *TreeNode) int {
	max := 0
	if root == nil {
		return max
	}
	l := maxDepth(root.Left)
	r := maxDepth(root.Right)
	if l > r {
		max = l
	} else {
		max = r
	}
	return max + 1
}
// @lc code=end

