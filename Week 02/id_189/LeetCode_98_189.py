#
# @lc app=leetcode.cn id=98 lang=python
#
# [98] 验证二叉搜索树
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 递归，参考 CN 站题解。2019.10.27 通过

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        def helper(node, upper=float('inf'), lower=float('-inf')):
            if not node:
                return True
                
            val = node.val
            if val <= lower or val >= upper:
                return False
            if not helper(node.left, val, lower):
                return False
            if not helper(node.right, upper, val):
                return False
            return True
        
        return helper(root)
        
# @lc code=end

