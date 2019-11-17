class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        if root:
            res.append(root.val)
            oper(root.left)
            oper(root.right)
        oper(root)
        return res
