package BinaryTree

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func inorderTraversal(root *TreeNode) []int {
	re := []int{}
	if root == nil {

	}
	f := func(r *TreeNode) {}
	f = func(r *TreeNode) {
		if r == nil {
			return
		}
		f(r.Left)
		re = append(re, r.Val)
		f(r.Right)
	}
	f(root)
	return re
}
