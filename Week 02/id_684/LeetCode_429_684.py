# -*- coding: utf8 -*-

"""
给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

例如，给定一个 3叉树 :

       1
     / ｜ \
   3   2  4
  / \
 5  6

返回其层序遍历:

[
     [1],
     [3,2,4],
     [5,6]
]
"""

# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        res_list = []
        if root is None:return res_list
        queue = [root]
        while queue:
            res = []
            node_list = []
            for node in queue:
                res.append(node.val)
                if node.children:node_list += node.children
            res_list.append(res)
            queue = node_list
        return res_list




if __name__ == '__main__':
    slt = Solution()
    root = Node(1, [])
    node2 = Node(2, [])
    node3 = Node(3, [])
    node4 = Node(4, [])
    node5 = Node(5, [])
    node6 = Node(6, [])
    node3.children.append(node5)
    node3.children.append(node6)
    root.children.append(node3)
    root.children.append(node2)
    root.children.append(node4)
    print(slt.levelOrder(root))