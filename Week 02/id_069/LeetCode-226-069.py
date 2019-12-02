# 20191025


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x, left, right):
        self.val = x
        self.left = left
        self.right = right

# class Solution:
#     def invertTree(self, root: TreeNode) -> TreeNode:
#         if root == None:
#             return
#         root.left, root.right = root.right, root.left
#         self.invertTree(root.left)
#         self.invertTree(root.right)
#         return root

# 光头大神的简化版

class Solution:
    def invertTree(self, root):
        if root:
            root.left, root.right = self.invertTree(root.right), self.invertTree(root.left)
            return root

B = TreeNode('B', None, None)
C = TreeNode('C', None, None)
A = TreeNode('A', B, C)

print(A.left.val)
print(A.right.val)
s = Solution()
s.invertTree(A)
print(A.left.val)
print(A.right.val)