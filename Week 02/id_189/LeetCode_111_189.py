#
# @lc app=leetcode.cn id=111 lang=python
#
# [111] 二叉树的最小深度
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 递归。
class Solution(object):
    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        
        if root is None:
            return 0
        if root.right == None or root.left == None:
            return self.minDepth(root.left) + self.minDepth(root.right) + 1
        else:
            return min(self.minDepth(root.right),self.minDepth(root.left)) + 1
            
# @lc code=end

