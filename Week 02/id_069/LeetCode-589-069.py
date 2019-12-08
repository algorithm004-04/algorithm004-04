#20191024

"""
前序遍历：
    1. 左节点
    2. 根节点
    3. 右节点
"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children

class Solution:
    def preorder(self, root):
        res = [] 
        self.helper(root, res)
        return res

    def helper(self, root, res):
        if root != None:
            res.append(root.val)
            for i in root.children:
                self.helper(i, res)
            