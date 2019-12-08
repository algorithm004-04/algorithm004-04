# coding=utf-8

"""
给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
例如，给定一个 3叉树 :
           1
        /  |  \
       3   2   4
     /  \
    5    6
返回其层序遍历:

[
     [1],
     [3,2,4],
     [5,6]
]

说明:
    树的深度不会超过 1000。
    树的节点总数不会超过 5000。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
"""

# Definition for a Node.
from typing import List


class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children


class Solution:
    def levelOrder(self, root: Node) -> List[List[int]]:
        result = []
        if not root:
            return result
        queue = [root]
        while len(queue) != 0:
            curr_level = []
            next_level = []
            for node in queue:
                curr_level.append(node.val)
                if node.children:
                    next_level.extend(node.children)
            result.append(curr_level)
            queue = next_level
        return result
