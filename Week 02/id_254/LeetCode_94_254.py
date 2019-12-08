# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


# class Solution:
#     def inorderTraversal(self, root):
#         res = []

#         def inorder(root):
#             if not root:
#                 return
#             inorder(root.left)
#             res.append(root.val)
#             inorder(root.right)
#         inorder(root)
#         return res


class Solution:
    def inorderTraversal(self, root):
        stack, res = [], []
        while stack or root:
            if root:
                stack.append(root)
                root = root.left
            else:
                top = stack.pop()
                res.append(top.val)
                root = top.right
        return res
