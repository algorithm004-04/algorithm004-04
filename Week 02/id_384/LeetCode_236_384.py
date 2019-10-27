class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.res = None
        self.xun(root, p, q)
        return self.res
    
    def xun(self, root, p, q):
        if not root:
            return 0
        
        left = self.xun(root.left, p, q)
        right = self.xun(root.right, p, q)
        
        mid = root == p or root == q
        if mid + left + right > 1:
            self.res = root
        return mid or left or right

