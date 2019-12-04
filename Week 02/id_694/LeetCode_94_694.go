/*
 * @lc app=leetcode.cn id=94 lang=golang
 *
 * [94] 二叉树的中序遍历
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

 func inorderTraversal(root *TreeNode) []int {
	res := []int{}
	if root != nil {
		left := inorderTraversal(root.Left)
		res = append(res, left...)
		res = append(res, root.Val)
		right := inorderTraversal(root.Right)
		res = append(res, right...)
	}
	return res
}
// @lc code=end

