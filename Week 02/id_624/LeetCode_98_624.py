#
# @lc app=leetcode.cn id=98 lang=python3
#
# [98] 验证二叉搜索树
#
# https://leetcode-cn.com/problems/validate-binary-search-tree/description/
#
# algorithms
# Medium (27.71%)
# Likes:    311
# Dislikes: 0
# Total Accepted:    45.5K
# Total Submissions: 164K
# Testcase Example:  '[2,1,3]'
#
# 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
# 
# 假设一个二叉搜索树具有如下特征：
# 
# 
# 节点的左子树只包含小于当前节点的数。
# 节点的右子树只包含大于当前节点的数。
# 所有左子树和右子树自身必须也是二叉搜索树。
# 
# 
# 示例 1:
# 
# 输入:
# ⁠   2
# ⁠  / \
# ⁠ 1   3
# 输出: true
# 
# 
# 示例 2:
# 
# 输入:
# ⁠   5
# ⁠  / \
# ⁠ 1   4
# / \
# 3   6
# 输出: false
# 解释: 输入为: [5,1,4,null,null,3,6]。
# 根节点的值为 5 ，但是其右子节点值为 4 。
# 
# 
#

# @lc code=start
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # def isValidBST(self, root: TreeNode) -> bool:
    #     def helper(root: TreeNode, lower=float('-inf'), upper=float('inf')):
    #         if not root: return True
    #         if root.val <= lower or root.val >= upper: return False
    #         if not helper(root.left, lower, root.val):
    #             return False
    #         if not helper(root.right, root.val, upper):
    #             return False
    #         return True
    #     return helper(root)

    # def isValidBST(self, root: TreeNode) -> bool:
    #     stack, temp, n = [], float('-inf'), root
    #     while stack or n:
    #         while n:
    #             stack.append(n)
    #             n = n.left
    #         n = stack.pop()
    #         if n.val <= temp: return False
    #         temp = n.val
    #         n = n.right
    #     return True
            
    # def isValidBST(self, root: TreeNode) -> bool:
    #     def helper(root: TreeNode, lower=float('-inf'), upper=float('inf')) -> bool:
    #         if not root: return True
    #         if root.val <= lower or root.val >= upper: return False
    #         if not helper(root.left, lower, root.val): return False
    #         if not helper(root.right, root.val, upper): return False
    #     return helper(root)

    # def isValidBST(self, root: TreeNode) -> bool:   
    #     stack, node, temp = [], root, float('-inf')
    #     while stack or node:
    #         while node:
    #             stack.append(node)
    #             node = node.left
    #         node = stack.pop()
    #         if node.val <= temp: return False
    #         temp = node.val
    #         node = node.right

    def isValidBST(self, root: TreeNode) -> bool:
        def helper(root: TreeNode, lower=float('-inf'), upper:=loat('inf')) -> bool:
            if not root: return True
            if root.val <= lower or root.val >= upper: return False
            if not helper(root.left, lower, root.val): return False
            if not helper(root.right, root.val, upper): return False
        return helper(root)


        
# @lc code=end

