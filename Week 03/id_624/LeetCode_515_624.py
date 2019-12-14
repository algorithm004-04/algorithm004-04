#
# @lc app=leetcode.cn id=515 lang=python3
#
# [515] 在每个树行中找最大值
#
# https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/description/
#
# algorithms
# Medium (57.02%)
# Likes:    45
# Dislikes: 0
# Total Accepted:    4.4K
# Total Submissions: 7.7K
# Testcase Example:  '[1,3,2,5,3,null,9]'
#
# 您需要在二叉树的每一行中找到最大的值。
# 
# 示例：
# 
# 
# 输入: 
# 
# ⁠         1
# ⁠        / \
# ⁠       3   2
# ⁠      / \   \  
# ⁠     5   3   9 
# 
# 输出: [1, 3, 9]
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
    def largestValues(self, root: TreeNode) -> List[int]:
        res = []
        def dfs(node=root, level=0):
            if node:
                if len(res) == level:
                    res.append(node.val)
                else:
                    res[level] = max(node.val, res[level])
                dfs(node.left, level+1)
                dfs(node.right, level+1)
        dfs()
        return res

# @lc code=end

