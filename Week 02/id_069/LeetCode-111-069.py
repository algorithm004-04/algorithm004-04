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
    3. 遍历左右子树，选择最小的
    4. 如果到达某节点其中有左节点或右节点为空，则返回当前长度+1
"""
class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if root == None:
            return 0
        if root.left == None and root.right == None:
            return 1
        numl, numr = 0, 0
        numl = self.minDepth(root.left)
        numr = self.minDepth(root.right)

        if root.left == None or root.right == None:
            return numl + numr + 1      #某个节点的左或右节点为空，则numl或numr有一个为0

        return min(numl, numr) + 1

        
        