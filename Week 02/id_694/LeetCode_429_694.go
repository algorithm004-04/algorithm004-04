/*
 * @lc app=leetcode.cn id=94 lang=golang
 *
 * [429] n叉树的层序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Children []*TreeNode
 * }
 */

func levelOrderTraversal(root *TreeNode) [][]int {
	res := [][]int{}
	if root == nil {
		return res
	}

	var levelNodes []*TreeNode{root}
	for len(levelNodes) > 0 {
		vals := []int{}
		nodes := []*TreeNode{}
		for _, v := range levelNodes {
			vals = append(vals, v.Val)
			if v.Children != nil {
				nodes = append(nodes, v.Children...)
			}
		}
		res = append(res, vals)
		levelNodes = nodes
	}

	return res
}

// @lc code=end

