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

    def inorderTraversal2(self, root: TreeNode) -> List[int]:
        """
        迭代法
        """
        if not root:
            return []
        current, stack, output = root, [], []
        while current or len(stack) > 0:
            while current:
                stack.append(current)
                current = current.left
            current = stack.pop()
            output.append(current.val)
            current = current.right
        return output


root = TreeNode(1)
root.right = TreeNode(2)
root.right.left = TreeNode(3)

print(Solution().inorderTraversal(root))
