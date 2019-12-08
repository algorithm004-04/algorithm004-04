# -*- coding: utf8 -*-

"""
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
﻿对于树中的任意节点来说，先打印它的左子树，然后再打印它的本身，最后打印它的右子树。
"""


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def inorderTraversal(self, root):
        """
        递归
        :type root: TreeNode
        :rtype: List[int]
        """
        res_list = []
        if root is not None:
            left_res_list = self.inorderTraversal(root.left)
            res_list = res_list + left_res_list
            res_list.append(root.val)
            right_res_list = self.inorderTraversal(root.right)
            res_list = res_list + right_res_list
        return res_list

    def inorderTraversal2(self, root):
        """
        迭代，利用栈
        :type root: TreeNode
        :rtype: List[int]
        """
        res_list = []
        stack = []
        if root is None:
            return res_list
        tree_node = root
        while stack or tree_node is not None:
            while tree_node is not None:
                #遍历节点左子树到叶子节点
                stack.append(tree_node)
                tree_node = tree_node.left
            #从栈中取出节点
            tree_node = stack.pop()
            res_list.append(tree_node.val)
            #当前节点是右节点，开始遍历
            tree_node = tree_node.right
        return res_list

    def inorderTraversal3(self, root):
        """
        迭代，利用栈，颜色标记法
        :type root: TreeNode
        :rtype: List[int]
        """
        white,grey = 0,1
        res_list = []
        stack = [(white,root)]
        while stack:
            color,tree_node = stack.pop()
            if tree_node is None:continue
            if color == white:
                stack.append((white,tree_node.right))
                stack.append((grey,tree_node))
                stack.append((white,tree_node.left))
            else:
                res_list.append(tree_node.val)
        return res_list

if __name__ == '__main__':
    slt = Solution()
    root = TreeNode(1)
    root.right = TreeNode(2)
    root.right.left = TreeNode(3)
    print(slt.inorderTraversal3(root))