from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        nodes = []
        nodes += self.inorderTraversal(root.left)
        nodes.append(root.val)
        nodes += self.inorderTraversal(root.right)
        return nodes


root = TreeNode(1)
root.right = TreeNode(2)
root.right.left = TreeNode(3)

print(Solution().inorderTraversal(root))
