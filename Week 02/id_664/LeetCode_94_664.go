package id_664

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

/**

   1. 判断树是否为空
   2. 递归遍历左右子树
   3. 左子树遍历的结果和根节点拼接
   4. 再拼接右子树遍历的结果
   5. return
*/

func inorderTraversal(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}
	left := inorderTraversal(root.Left)
	right := inorderTraversal(root.Right)
	left = append(left, root.Val)
	left = append(left, right...)
	return left
}
