#
# @lc app=leetcode.cn id=144 lang=python3
#
# [144] 二叉树的前序遍历
#
# https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
#
# algorithms
# Medium (62.00%)
# Likes:    165
# Dislikes: 0
# Total Accepted:    48.7K
# Total Submissions: 78K
# Testcase Example:  '[1,null,2,3]'
#
# 给定一个二叉树，返回它的 前序 遍历。
# 
# 示例:
# 
# 输入: [1,null,2,3]  
# ⁠  1
# ⁠   \
# ⁠    2
# ⁠   /
# ⁠  3 
# 
# 输出: [1,2,3]
# 
# 
# 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
# 
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        def _preorderTraversal(treeNode):
            if treeNode:
                result.append(treeNode.val)
                if treeNode.left:
                    _preorderTraversal(treeNode.left)
                if treeNode.right:
                    _preorderTraversal(treeNode.right)
        
        _preorderTraversal(root)
        return result

        
# @lc code=end

