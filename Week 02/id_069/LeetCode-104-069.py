#20191027



# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


"""
    递归：
    1. 节点为空时返回0
    2. 节点没有左右子节点返回1
    3. 遍历左右子树，选择最大的
    4. 完全遍历所有节点（这点与最小深度有区别）
"""
class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if root == None:
            return 0
        if root.left == None and root.right == None:
            return 1

        numl, numr = 0, 0
        numl = self.maxDepth(root.left)
        numr = self.maxDepth(root.right)

        return max(numl, numr) + 1

        
        