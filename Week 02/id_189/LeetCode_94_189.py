#
# @lc app=leetcode.cn id=94 lang=python
#
# [94] 二叉树的中序遍历
#

# 1. 递归
# 2019.10.26 

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# class Solution(object):
#     def helper(self, root, res):
#         if root:
#             self.helper(root.left, res)
#             res.append(root.val)
#             self.helper(root.right, res)
#     def inorderTraversal(self, root):
#         """
#         :type root: TreeNode
#         :rtype: List[int]
#         """       
#         res = []
#         self.helper(root, res)
#         return res
        
# 2. 迭代
# @lc code=start


class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """       

        res, stack = [], []

        while True:
            while root:
                stack.append(root)
                root = root.left 
            if not stack:
                return res
            node = stack.pop()
            res.append(node.val)
            root = node.right




# @lc code=end

