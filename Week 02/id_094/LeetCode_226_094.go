/*
 * @lc app=leetcode id=226 lang=golang
 *
 * [226] Invert Binary Tree
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
 //自底向上
func invertTree(root *TreeNode) *TreeNode {
    if root == nil {
		return nil
	}
	root.Left, root.Right = invertTree(root.Right), invertTree(root.Left)
	return root
}
//自顶向下
func invertTree(root *TreeNode) *TreeNode {
    if root == nil {
		return nil
	}
	root.Left, root.Right = root.Right, root.Left
	invertTree(root.Left)
	invertTree(root.Right)
	return root
}

//bfs + queue
// func invertTree(root *TreeNode) *TreeNode{
// 	if root == nil {
// 		return nil
// 	}
// 	q := NewQueue()
// 	q.Push(root)
// 	for q.Len() != 0 {
// 		tmp := q.Pop()
// 		tmp.Left, tmp.Right = tmp.Right, tmp.Left //swap
// 		if tmp.Left != nil {
// 			q.Push(tmp.Left)
// 		}
// 		if tmp.Right != nil {
// 			q.Push(tmp.Right)
// 		}
// 	}
// 	return root
// }

// type Queue struct {
// 	data *list.List
// }
// func NewQueue() *Queue {
// 	return &Queue{data:list.New()}
// }
// func(q *Queue)Push(v *TreeNode) {
// 	q.data.PushBack(v)
// }
// func(q *Queue)Pop() *TreeNode {
// 	t := q.data.Front()
// 	q.data.Remove(t)
// 	return t.Value.(*TreeNode)
// }
// func(q *Queue)Len() int {
// 	return q.data.Len()
// }
// @lc code=end

