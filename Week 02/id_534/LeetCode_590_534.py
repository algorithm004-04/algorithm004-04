class Solution(object):
    def postorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        self.res = []
        if root:
            self.helper(root)
            self.res.append(root.val)
        return self.res
    
    def helper(self, roots):
        if roots:
            for chl in roots.children:
                self.helper(chl)
                self.res.append(chl.val)
