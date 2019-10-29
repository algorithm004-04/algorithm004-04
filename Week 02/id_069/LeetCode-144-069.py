#20191024

"""
    前序遍历：
    1. 根节点
    2. 左节点
    3. 右节点
"""

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# class Solution:
#     def preorderTraversal(self, root):
#         res = []
#         self.helper(root, res)
#         return res

#     def helper(self, root, res):
#         if root != None:        # 需要在这里增加判断防止下一个节点为None
#             res.append(root.val)
#             if root.left != None:
#                 self.helper(root.left, res)
#             if root.right != None:
#                 self.helper(root.right, res)

"""
    手动维护一个栈
"""

# class Solution:
#     def preorderTraversal(self, root):
#         res, stack = [], []
#         cur = root
#         while cur or stack:
#             while cur:
#                 stack.append(cur)
#                 res.append(cur.val)
#                 cur = cur.left  
#             cur = stack.pop()
#             cur = cur.right
#         return res

# 第二种写法

class Solution:
    def preorderTraversal(self, root):
        res = []
        stack = [root]
        while stack:
            node = stack.pop()
            if node:
                res.append(node.val)
                stack.append(node.right)
                stack.append(node.left)
        return res
