#
# @lc app=leetcode id=236 lang=python3
#
# [236] Lowest Common Ancestor of a Binary Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # Variable to store LCA node.
        self.ancestor = None

        def recurse_tree(current_node):
            # If reached the end of a branch, return False.
            if not current_node:
                return False
            
            #Left Recursion
            foundLeft = recurse_tree(current_node.left)

            #Right Recursion
            foundRight = recurse_tree(current_node.right)

            #If the current node is one of p or q
            foundMid = current_node == p or current_node == q

            # If any two of the three flags left, right or mid become True.
            if foundLeft + foundRight + foundMid >= 2:
                self.ancestor = current_node

            # Return True if either of the three bool values is True.
            return foundLeft or foundRight or foundMid
                
        # Traverse the tree
        recurse_tree(root)
        return self.ancestor
            
# @lc code=end

