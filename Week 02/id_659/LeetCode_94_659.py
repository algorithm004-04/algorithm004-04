# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:


    def inorderTraversal(self, root: TreeNode) -> List[int]:
        node_list  = []
        self.order_traversal(root,node_list)
        return node_list

    def order_traversal(self,root: TreeNode,res: List[int]):
        if not root:
            return
        if root.left:
            self.order_traversal(root.left,res)
        res.append(root.val)
        if root.right:
            self.order_traversal(root.right,res)