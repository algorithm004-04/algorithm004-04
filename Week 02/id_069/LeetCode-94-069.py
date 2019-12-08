# 20191024


"""
    二叉树中序遍历：
    1. 左节点
    2. 根节点
    3. 右节点
"""
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x, left= None, right= None):
        self.val = x
        self.left = left
        self.right = right

# class Solution:
#     def inorderTraversal(self, root):
#         res = []
#         self.helper(root, res)
#         return res

#     def helper(self, root, res):
#         if root != None:
#             if root.left != None:
#                 self.helper(root.left, res)
#             res.append(root.val)
#             if root.right != None:
#                 self.helper(root.right, res)



"""
    手动维护一个栈
"""

class Solution:
    def inorderTraversal(self, root):
        res = []
        stack = []
        cur = root
        while cur  or stack:
            while cur:
                stack.append(cur)
                cur = cur.left
            cur = stack.pop()
            res.append(cur.val)
            cur = cur.right
        return res

        



B = TreeNode('B', None, None)
C = TreeNode('C', None, None)
A = TreeNode('A', B, C)


s = Solution()
print(s.inorderTraversal(A))