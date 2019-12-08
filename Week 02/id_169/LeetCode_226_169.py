class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        """
        递归法
        """
        if not root: return root
        root.left, root.right = self.invertTree(root.right), self.invertTree(root.left)
        return root

    def invertTree2(self, root: TreeNode) -> TreeNode:
        """
        迭代法
        """
        if not root: return root
        stack = [root]
        while len(stack) > 0:
            node = stack.pop()
            node.left, node.right = node.right, node.left
            if node.left: stack.append(node.left)
            if node.right: stack.append(node.right)
        return root
