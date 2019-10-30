class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def inorderTraversal(root: TreeNode):
    res = []

    def recursive(root):
        if not root:
            return
        recursive(root.left)
        res.append(root.val)
        recursive(root.right)
    recursive(root)
    return res

