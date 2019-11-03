/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

 var preIdx int
 var pre []int
 var in []int
 var idxMap map[int]int

func buildTree(preorder []int, inorder []int) *TreeNode {
	pre = preorder
	in = inorder
	preIdx = 0
	idxMap = make(map[int]int)

	var idx int = 0
	for _, v := range inorder {
		idxMap[v] = idx
		idx++
	}
	return helper(0, len(inorder))
}

func helper(inLeft, inRight int) *TreeNode {
	if inLeft == inRight {
		return nil
	}

	var rootVal int = pre[preIdx]
	root := new(TreeNode)
	root.Val = rootVal

	index := idxMap[rootVal]
	preIdx++
	root.Left = helper(inLeft, index)
	root.Right = helper(index+1, inRight)
	return root
}
