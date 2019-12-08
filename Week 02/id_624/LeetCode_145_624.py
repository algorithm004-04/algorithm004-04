#
# @lc app=leetcode.cn id=145 lang=python3
#
# [145] 二叉树的后序遍历
#
# https://leetcode-cn.com/problems/binary-tree-postorder-traversal/description/
#
# algorithms
# Hard (68.07%)
# Likes:    173
# Dislikes: 0
# Total Accepted:    33.7K
# Total Submissions: 49.4K
# Testcase Example:  '[1,null,2,3]'
#
# 给定一个二叉树，返回它的 后序 遍历。
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
# 输出: [3,2,1]
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
    # 右子树优先的先序遍历，然后逆序返回结果
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        stack, res = [root], []
        while stack:
            c = stack.pop()
            if c:
                res.append(c.val)
                stack.append(c.left)
                stack.append(c.right)
        return res[::-1]
        
# @lc code=end

