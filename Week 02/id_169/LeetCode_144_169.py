from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        if not root: return []
        return [root.val] + self.preorderTraversal(root.left) + self.preorderTraversal(root.right)


root = TreeNode(1)
root.right = TreeNode(2)
root.right.left = TreeNode(3)

print(Solution().preorderTraversal(root))
