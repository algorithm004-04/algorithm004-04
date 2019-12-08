/*
 * @lc app=leetcode id=111 lang=golang
 *
 * [111] Minimum Depth of Binary Tree
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
func minDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	q := NewQueue()
	q.Push(root)
	level := 0
	for q.Len() != 0 {
		level++
		size := q.Len()
		for i:=0; i<size; i++ {
			tmp := q.Pop()
			if tmp.Left == nil && tmp.Right == nil {
				return level
			}
			if tmp.Left != nil {
				q.Push(tmp.Left)
			}
			if tmp.Right != nil {
				q.Push(tmp.Right)
			}
		}
	}
	return level
}

type Queue struct {
	data *list.List
}

func NewQueue() *Queue {
	return &Queue{data:list.New()}
}

func (q *Queue)Push(v *TreeNode) {
	q.data.PushBack(v)
}

func (q *Queue)Pop() *TreeNode {
	tmp := q.data.Front()
	q.data.Remove(tmp)
	return tmp.Value.(*TreeNode)
}

func (q *Queue)Len() int {
	return q.data.Len()
}
// @lc code=end

