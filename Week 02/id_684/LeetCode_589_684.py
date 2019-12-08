# -*- coding: utf8 -*-

"""
给定一个 N 叉树，返回其节点值的前序遍历。

例如，给定一个 3叉树 :

       1
     / ｜ \
   3   2  4
  / \
 5  6

返回其后序遍历: [1,3,5,6,2,4].
﻿前序遍历：对于树中的任意节点来说，先打印它本身，然后打它的左子树，最后再打印它的右子树。
"""

# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children

class Solution(object):
    def preorder(self, root):
        """
        迭代法
        :type root: Node
        :rtype: List[int]
        """
        res_list = []
        if root is None: return res_list
        stack = [root]
        while stack:
            tree_node = stack.pop()
            res_list.append(tree_node.val)
            while tree_node.children:
                stack.append(tree_node.children.pop())



if __name__ == '__main__':
    slt = Solution()
    root = Node(1,[])
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

    slt.preorder(root)