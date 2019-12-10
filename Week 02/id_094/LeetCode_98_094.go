/*
 * @lc app=leetcode id=98 lang=golang
 *
 * [98] Validate Binary Search Tree
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

 //方法1：分治, 和上下界比较
func isValidBST(root *TreeNode) bool {
   return helper(root, nil, nil)
}
func helper(node, lower, upper *TreeNode) bool {
	if node == nil  {
		return true
	}
	val := node.Val
	if (lower != nil && val <= lower.Val) ||
 	    (upper != nil && val >= upper.Val) {
		return false
	}

	if !helper(node.Left, lower, node) ||
	   !helper(node.Right, node, upper) {
		return false
	}
	return true
}
//方法2：中序，和最近一次访问的节点比较 O(N)
func isValidBST(root *TreeNode) bool {
	var last *TreeNode
	return validate(root, &last)
}

func validate(node *TreeNode, last **TreeNode) bool {
	if node == nil {
		return true
	}
	if !validate(node.Left, last) {
		return false
	}
	if *last != nil && (*last).Val >= node.Val {
		return false
	}
	if !validate(node.Right, &node) {
		return false
	}

	*last = node
	return true
}
// @lc code=end

