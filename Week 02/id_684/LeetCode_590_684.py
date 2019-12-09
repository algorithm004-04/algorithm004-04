# -*- coding: utf8 -*-

"""
给定一个 N 叉树，返回其节点值的后序遍历。

例如，给定一个 3叉树 :

       1
     / ｜ \
   3   2  4
  / \
 5  6

返回其后序遍历: [5,6,3,2,4,1].
﻿后序遍历：对于树中的任意节点来说，先打印它的左子树，然后再打印它的右子树，最后打印它本身。
树的后序遍历一般都是两个栈完成，
"""

# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children

class Solution(object):
    def postorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        res_list = []
        if root is None:return res_list
        stack = [root]
        stack1 = []
        while stack:
            tree_node =stack.pop()
            if tree_node.children:
                stack = stack + tree_node.children
            stack1.append(tree_node)
        while stack1:
            res_list.append(stack1.pop().val)
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
    slt.postorder(root)