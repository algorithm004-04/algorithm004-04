# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


# class Solution:
#     def preorderTraversal(self, root):
#         res = []

#         def preOrder(r):
#             if not r:
#                 return
#             res.append(r.val)
#             preOrder(r.left)
#             preOrder(r.right)
#         preOrder(root)
#         return res


class Solution:
    def preorderTraversal(self, root):
        result = []
        stack = [root]
        while stack:
            top = stack.pop()
            if top is not None:
                result.append(top.val)
                if top.right is not None:
                    stack.append(top.right)
                if top.left is not None:
                    stack.append(top.left)
        return result
