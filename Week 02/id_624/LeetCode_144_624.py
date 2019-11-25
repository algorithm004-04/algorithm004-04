#
# @lc app=leetcode.cn id=144 lang=python3
#
# [144] 二叉树的前序遍历
#
# https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
#
# algorithms
# Medium (62.04%)
# Likes:    162
# Dislikes: 0
# Total Accepted:    45.4K
# Total Submissions: 73.1K
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

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # 递归法
    # def preorderTraversal(self, root: TreeNode) -> List[int]:
    #     res = []
        
    #     def helper(root: TreeNode):
    #         if not root: return
    #         res.append(root.val)
    #         helper(root.left)
    #         helper(root.right)

    #     helper(root)
    #     return res

    # 栈迭代法
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        stack  = []
        p = root

        while p or stack:
            while p: 
                res.append(p.val)
                stack.append(p)
                p = p.left
            p = stack.pop().right
            
        return res


# @lc code=end

