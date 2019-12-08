func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	// 找到了一个节点，返回那个节点，或者找到了叶子节点，直接返回
    if root == p || root == q || root == nil {  
        return root
	}
	 // 如果该子树下包含要找的节点，那么返回该节点地址，否则返回 nil
    l := lowestCommonAncestor(root.Left,p,q) 
    r := lowestCommonAncestor(root.Right,p,q)
    if l!=nil && r!=nil {  
        return root
    } else if l != nil { 
        return l
    } else if r != nil {
        return r
    }
    return nil  
}