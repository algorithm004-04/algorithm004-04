#
# @lc app=leetcode.cn id=102 lang=python3
#
# [102] 二叉树的层次遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque
class Solution:

    # DFS
    """
    Use a variable to track level in the tree and use simple Pre-Order traversal
    Add sub-lists to result as we move down the levels
    Time Complexity: O(N)
    Space Complexity: O(N) + O(h) for stack space
    """
    def levelOrder1(self, root: TreeNode) -> List[List[int]]:
        levels = []
        if not root:
            return levels

        def helper(node, level):
            # start the current level
            if len(levels) == level:
                levels.append([])

            # append the current node value
            levels[level].append(node.val)

            # process child nodes for the next level
            if node.left:
                helper(node.left, level+1)
            if node.right:
                helper(node.right, level+1)

        helper(root, 0)

        return levels

    # BFS
    """
    Using BFS, at any instant only L1 and L1+1 nodes are in the queue.
    When we start the while loop, we have L1 nodes in the queue.
    for _ in range(len(q)) allows us to dequeue L1 nodes one by one and add L2 children one by one.
    Time complexity: O(N). Space Complexity: O(N)
    """
    def levelOrder2(self, root: TreeNode) -> List[List[int]]:
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        q, result = deque(), []
        if root:
            q.append(root)
        while len(q):
            level = []
            for _ in range(len(q)):
                x = q.popleft()
                level.append(x.val)
                if x.left:
                    q.append(x.left)
                if x.right:
                    q.append(x.right)
            result.append(level)
        return result

        
# @lc code=end

