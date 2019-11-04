class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def maxDepth(self, root: TreeNode):     # 递归
    def recursive(self, root):
        if root is None:
            return 0
        else:
            left_depth = self.recursive(root.left)
            right_depth = self.recursive(root.right)
        return max(left_depth, right_depth) + 1


