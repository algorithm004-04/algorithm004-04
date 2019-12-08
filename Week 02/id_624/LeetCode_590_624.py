#
# @lc app=leetcode.cn id=590 lang=python3
#
# [590] N叉树的后序遍历
#
# https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/description/
#
# algorithms
# Easy (70.17%)
# Likes:    36
# Dislikes: 0
# Total Accepted:    10.5K
# Total Submissions: 14.9K
# Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
#
# 给定一个 N 叉树，返回其节点值的后序遍历。
# 
# 例如，给定一个 3叉树 :
# 
# 
# 
# 
# 
# 
# 
# 返回其后序遍历: [5,6,3,2,4,1].
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
    def postorder(self, root: Node) -> List[int]:
        res = []
        
        def helper(root: Node):
            if not root: return
            for c in root.children: helper(c)
            res.append(root.val)

        helper(root)
        return res

        
# @lc code=end

