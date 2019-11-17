class Solution(object):
    def preorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        self.res = []
        if root:
            self.res.append(root.val)
            self.helper(root)
        return self.res
        
    def helper(self, roots):
        if roots:
            for chl in roots.children:
                self.res.append(chl.val)
                self.helper(chl)
