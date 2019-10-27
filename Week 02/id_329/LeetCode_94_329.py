# coding=utf-8

"""
给定一个二叉树，返回它的中序 遍历。

示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3
输出: [1,3,2]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
"""

# Definition for a binary tree node.
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 1. 递归法
    # 前序遍历，中序遍历，后序遍历，只需要更改下代码顺序即可；维护很方便
    # 时间复杂度: O(N)
    # 空间复杂度: O(N)
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        self._inorder_traversal(root, result)
        return result

    def _inorder_traversal(self, root: TreeNode, _result: List[int]):
        if not root:
            return
        if root.left:
            self._inorder_traversal(root.left, _result)
        _result.append(root.val)
        if root.right:
            self._inorder_traversal(root.right, _result)

    # 2. 利用栈实现
    # 本质还是递归，手动维护一个栈；递归是自动维护一个栈
    # 时间复杂度： O(N)
    # 空间复杂度: O(N)
    def inorderTraversal2(self, root: TreeNode) -> List[int]:
        result = []
        if not root:
            return result
        stack = []
        curr = root
        while curr or len(stack) != 0:
            while curr:
                stack.append(curr)
                curr = curr.left
            curr = stack.pop()
            result.append(curr.val)
            curr = curr.right
        return result


if __name__ == '__main__':
    # origin data
    root_node = TreeNode(1)
    root_node.right = TreeNode(2)
    root_node.right.left = TreeNode(3)

    so = Solution()
    print(so.inorderTraversal2(root_node))

