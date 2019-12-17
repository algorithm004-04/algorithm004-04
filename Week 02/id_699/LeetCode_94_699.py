#
# @lc app=leetcode.cn id=94 lang=python3
#
# [94] 二叉树的中序遍历
#
# https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
#
# algorithms
# Medium (68.26%)
# Likes:    315
# Dislikes: 0
# Total Accepted:    73.7K
# Total Submissions: 107K
# Testcase Example:  '[1,null,2,3]'
#
# 给定一个二叉树，返回它的中序 遍历。
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
# 输出: [1,3,2]
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
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        def _inorderTraversal(treeNode):
            if treeNode:
                if treeNode.left:
                    _inorderTraversal(treeNode.left)
                result.append(treeNode.val)
                if treeNode.right:
                    _inorderTraversal(treeNode.right)
        
        _inorderTraversal(root)
        return result

        
# @lc code=end

