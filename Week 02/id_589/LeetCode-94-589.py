#
# @lc app=leetcode id=94 lang=python3
#
# [94] Binary Tree Inorder Traversal
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        # self.helper(root,res)
        self.inorderTraversal2(root, res)
        return res

    # recursive solution
    def helper(self, root, res) -> List[int]:
        if root:
            self.helper(root.left, res)
            res.append(root.val)
            self.helper(root.right, res)

    # iteration solution
    def inorderTraversal2(self, root, res):
        stack = []
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

