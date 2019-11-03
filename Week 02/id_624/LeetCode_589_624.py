#
# @lc app=leetcode.cn id=589 lang=python3
#
# [589] N叉树的前序遍历
#
# https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
#
# algorithms
# Easy (70.14%)
# Likes:    56
# Dislikes: 0
# Total Accepted:    12.3K
# Total Submissions: 17.5K
# Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
#
# 给定一个 N 叉树，返回其节点值的前序遍历。
# 
# 例如，给定一个 3叉树 :
# 
# 
# 
# 
# 
# 
# 
# 返回其前序遍历: [1,3,5,6,2,4]。
# 
# 
# 
# 说明: 递归法很简单，你可以使用迭代法完成此题吗?
#

# @lc code=start
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children

class Solution:

    # 递归解法
    # def preorder(self, root: Node) -> List[int]:
    #     res = []

    #     def helper(root: Node):
    #         if not root: return
    #         res.append(root.val)
    #         for c in root.children: helper(c)
        
    #     helper(root)
    #     return res

    # 栈迭代解法
    def preorder(self, root: Node) -> List[int]:
        if not root: return []
        stack, res = [root], []
        while stack:
            p = stack.pop()
            res.append(p.val)
            for c in p.children[::-1]: stack.append(c)
        return res

        
# @lc code=end

