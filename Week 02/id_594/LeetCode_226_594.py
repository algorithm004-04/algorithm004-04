class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def invertTree(self, root: TreeNode):
    if root:
        invert = self.invertTree
        root.left, root.right = invert(root.right), invert(root.left)
    return root
