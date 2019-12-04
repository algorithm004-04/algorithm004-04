class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        def oper(root):
            if root:
                oper(root.left)
                res.append(root.val)
                oper(root.right)
        oper(root)
        return res
