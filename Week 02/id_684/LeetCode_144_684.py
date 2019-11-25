# -*- coding: utf8 -*-

"""
给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,2,3]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
﻿先打印这个节点，然后打印他的左子树，最后打印它的右子树。
"""
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def preorderTraversal(self, root):
        """
        递归
        :type root: TreeNode
        :rtype: List[int]
        """
        res_list = []
        if root is None:
            return res_list
        res_list.append(root.val)
        res_left_list = self.preorderTraversal(root.left)
        res_list = res_list + res_left_list
        res_right_list = self.preorderTraversal(root.right)
        res_list = res_list + res_right_list
        return res_list

    def preorderTraversal2(self, root):
        """
        迭代，利用队列
        :type root: TreeNode
        :rtype: List[int]
        """
        res_list = []
        if root is None:
            return res_list
        stack = []
        tree_node = root
        while tree_node is not None or stack:
            while tree_node is not None:
                #当前节点
                res_list.append(tree_node.val)
                stack.append(tree_node)
                tree_node = tree_node.left
            tree_node = stack.pop()
            tree_node = tree_node.right
        return res_list

    def preorderTraversal3(self, root):
        """
        迭代，利用队列
        :type root: TreeNode
        :rtype: List[int]
        """
        white, grey = 0, 1
        res_list = []
        stack = [(white, root)]
        while stack:
            color, tree_node = stack.pop()
            if tree_node is None: continue
            if color == white:
                stack.append((white, tree_node.right))
                stack.append((white, tree_node.left))
                stack.append((grey, tree_node))
            else:
                res_list.append(tree_node.val)
        return res_list

if __name__ == '__main__':
    slt = Solution()
    root = TreeNode(1)
    root.right = TreeNode(2)
    root.right.left = TreeNode(3)
    print(slt.preorderTraversal2(root))