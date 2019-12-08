class TreeNode:
    def __init__(self, val: int):
        self.val = val
        self.left, self.right = None, None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        self.pre_order(root, res)
        return res
    
    def pre_order(self, node: TreeNode, res: List[int]):
        if node == None:
            return
        res.append(node.val)
        self.pre_order(node.left, res)
        self.pre_order(node.right, res)
        
