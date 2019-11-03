#
# @lc app=leetcode id=145 lang=python3
#
# [145] Binary Tree Postorder Traversal
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        self.helper(root, res)
        return res
    def helper(self, root: TreeNode, res: List[int]):
        if root:
            self.helper(root.left, res)
            self.helper(root.right, res)
            res.append(root.val)
        
# @lc code=end

