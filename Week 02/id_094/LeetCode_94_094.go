/*
 * @lc app=leetcode id=94 lang=golang
 *
 * [94] Binary Tree Inorder Traversal
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
	if root == nil {
		return []int{}
	}

	path := []int{}
	path = append(path, inorderTraversal(root.Left)...)
	path = append(path, root.Val)
	path = append(path, inorderTraversal(root.Right)...)
	return path
}

//方法2:迭代 + stack
//三种情况
//1.stack.top==nil: continue
//2.visited: append
//3.not visited: push(r, top, l)
type Node struct {
	Visited bool
	*TreeNode
}

func inorderTraversalV2(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}
	path := []int{}
	stack := NewStack()
	stack.Push(&Node{false, root})
	for !stack.Empty() {
		top := stack.Pop()
		if top.TreeNode == nil {
			continue
		}

		if top.Visited {
			path = append(path, top.Val)
		} else {
			stack.Push(&Node{false, top.Right})
			stack.Push(&Node{true, top.TreeNode})
			stack.Push(&Node{false, top.Left})
		}
	}
	return path
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

