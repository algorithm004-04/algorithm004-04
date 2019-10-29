#20191024


"""
    后序遍历：
    1. 左节点
    2. 右节点
    3. 根节点
"""

"""
    递归法：
    1. 判断当前节点是否存在
    2. 存在则扫描该节点的子节点是否存在
        a. 如果存在则从左到右的顺序依次访问
        b. 如果不存在则说明这个节点为单独的节点，则可以把该节点填入
           列表中
    以此往复可以都得到从左到右，从下到上的节点顺序
"""

# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
        
class Solution:
    def postorder(self, root):
        res = []
        self.helper(root, res)
        return res
    
    def helper(self, root, res):
        if root != None:
            for i in root.children:
                self.helper(i)
            res.append(root.val)



