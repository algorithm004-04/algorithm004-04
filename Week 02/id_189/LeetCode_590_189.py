#
# @lc app=leetcode.cn id=590 lang=python
#
# [590] N叉树的后序遍历
#

# 1. 递归

# @lc code=start
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution(object):

    def postorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        res = []

        if root == None: return res

        def recursion(root, res):
            for child in root.children:
                    recursion(child, res)
            
            res.append(root.val)

        recursion(root, res)
        return res
        
# @lc code=end

