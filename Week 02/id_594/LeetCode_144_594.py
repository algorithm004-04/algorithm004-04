class TreeNode:
    def __init__(self, x):
        self.node = x
        self.right = None
        self.left = None

def preorderTraversal(root: TreeNode):
    res = []

    def recursive(root):
        if not root:
            return
        else:
            res.append(root.val)
            recursive(root.left)
            recursive(root.right)
        recursive(root)
    return res

