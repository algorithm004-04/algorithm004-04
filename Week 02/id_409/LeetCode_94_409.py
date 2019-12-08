# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        self.inorder(root, result)
        return result

    def inorder(self, node: TreeNode, res: List[int]):
        if node == None:
            return
        self.inorder(node.left, res)
        res.append(node.val)
        self.inorder(node.right, res)
        
