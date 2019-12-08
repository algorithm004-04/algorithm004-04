/*
 * @lc app=leetcode id=102 lang=golang
 *
 * [102] Binary Tree Level Order Traversal
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
func levelOrder(root *TreeNode) [][]int {
	ret := [][]int{}
	if root == nil {
		return ret
	}
	q := NewQueue()
	q.Push(root)
	for q.Len() != 0 {
		cur := []int{}
		size := q.Len()
		for i:=0; i<size; i++ {
			tmp := q.Pop()
			cur = append(cur, tmp.Val)
			if tmp.Left != nil {
				q.Push(tmp.Left)
			}
			if tmp.Right != nil {
				q.Push(tmp.Right)
			}
		}
		ret = append(ret, cur)
	}
	return ret
}

type Queue struct {
	data *list.List //注意指针
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

