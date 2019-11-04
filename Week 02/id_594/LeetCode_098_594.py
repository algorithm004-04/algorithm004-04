class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def isValidBST(self, root: TreeNode):
    return self.recursive(root, -float('-inf'), float('inf'))           # 唯一不懂的是，float里面为啥是字符串呢


def recursive(self, root, left_bound, right_bound):
    if root.val <= left_bound or root.val >= right_bound:
        return False
    if not root:
        return True
    left = self.recursive(root.left, left_bound, root.val)
    right = self.recursive(root.right, root.val, right_bound)
    return left and right

# 左子树的节点val必须小于根节点
# 右子树的节点val必须大于根节点
# 所有left_bound和right_bound就作为了左右边界，如果左子树节点大于了root.val=5，就越界，返回false
