/*
 * @lc app=leetcode id=144 lang=golang
 *
 * [144] Binary Tree Preorder Traversal
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
func preorderTraversal(root *TreeNode) []int {
    if root == nil {
		return []int{}
	}
	ret := []int{}
	ret = append(ret, root.Val)
	ret = append(ret, preorderTraversal(root.Left)...)
	ret = append(ret, preorderTraversal(root.Right)...)
	return ret
}

func preorderTraversalV2(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}
	ret := []int{}
	stack := NewStack()
	stack.Push(&Node{0, root})
	for !stack.Empty() {
		top := stack.Pop()
		if top.TreeNode == nil {
			continue
		}
		if top.Visit == 0 {
			stack.Push(&Node{0, top.Right})
			stack.Push(&Node{0, top.Left})
			stack.Push(&Node{1, top.TreeNode})
		} else {
			ret = append(ret, top.Val)
		}
	}
	return ret
}
type Node struct {
	Visit int
	*TreeNode
}

type Stack struct {
	data []*Node
}
func NewStack() *Stack {
	return &Stack{}
}

func(s *Stack) Push(n *Node) {
	s.data = append(s.data, n)
}

func(s *Stack) Pop() *Node {
	len := len(s.data)
	n := s.data[len-1]
	s.data = s.data[:len-1]
	return n
}

func(s *Stack)Empty() bool {
	return len(s.data) == 0
}
// @lc code=end

