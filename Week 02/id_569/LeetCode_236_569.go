package main

import "fmt"

///////////////////////////
////////////////想半么构造树的结构 实在不会写啦

// 二叉树的数据结构
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// 二叉树的实现
type Tree struct {
	root *TreeNode
}

func main() {

	zero := TreeNode{
		Val:   0,
		Left:  nil,
		Right: nil,
	}
	eight := TreeNode{
		Val:   8,
		Left:  nil,
		Right: nil,
	}

	one := TreeNode{
		Val:   1,
		Left:  &zero,
		Right: &eight,
	}

	four := TreeNode{
		Val:   4,
		Left:  nil,
		Right: nil,
	}
	seven := TreeNode{
		Val:   7,
		Left:  nil,
		Right: nil,
	}
	two := TreeNode{
		Val:   2,
		Left:  &seven,
		Right: &four,
	}
	six := TreeNode{
		Val:   6,
		Left:  nil,
		Right: nil,
	}
	five := TreeNode{
		Val:   5,
		Left:  &six,
		Right: &two,
	}
	three := TreeNode{
		Val:   3,
		Left:  &five,
		Right: &one,
	}

	r := lowestCommonAncestor(&three, &five, &one)
	fmt.Printf("num is : %+v ", r)
}

// 如果p、q都在二叉树中，则返回p、q二者的最近公共祖先
// 如果只有一个节点在二叉树中，则返回找到的这个节点
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	// 找到了一个节点，返回那个节点，或者找到了叶子节点，直接返回
	if root == nil || root == p || root == q {
		return root // 返回当前节点
	}
	// 否则递归调用自己，分别到左右子树上去处理
	// 如果该子树下包含要找的节点，那么返回该节点地址，否则返回 nil
	left := lowestCommonAncestor(root.Left, p, q)
	right := lowestCommonAncestor(root.Right, p, q)
	// 如果返回的结果left和right都不为空，说明左右子树上各自找到p或q节点
	if left != nil && right != nil {
		return root // 所以它们最近公共祖先就是当前节点
	} else if left != nil {
		return left
	} else if right != nil {
		return right
	}
	return nil
}
