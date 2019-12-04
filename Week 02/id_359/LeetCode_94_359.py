# 94. 二叉树的中序遍历
# https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
# 解法：递归调用

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    
    def __init__(self):
        self.list = []
        
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        # edge case consider
        if not root:
            return self.list
        if root.left != None:
            self.inorderTraversal(root.left)
        self.list.append(root.val)
        if root.right != None:
            self.inorderTraversal(root.right)
        return self.list
