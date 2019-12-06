class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        self.a = []
        self.xun(root)
        return self.a
        
    def xun(self, root):    
        if root:
            self.xun(root.left)
            self.a.append(root.val)
            self.xun(root.right)
