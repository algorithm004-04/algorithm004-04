class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        self.a = []
        self.xun(root)
        return self.a
    
    def xun(self, root):
        if root:
            self.a.append(root.val)
            self.xun(root.left)
            self.xun(root.right)
