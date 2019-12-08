#!/usr/bin/env python
#-*-coding:utf-8-*-
# author:lwz
from collections import deque

class TreeNode(object):
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None


class Solution(object):
    def __init__(self):
        self.traverse_path = []
        self.root = None # 整棵树的根节点

    def inorder(self, root):
        "二叉树的中序遍历"
        if root:
            self.inorder(root.left)
            self.traverse_path.append(root.val)
            self.inorder(root.right)

    def inInsert(self, nums):
        "将数组转化为二叉树"
        if not nums:
            return None
        self.root = TreeNode(nums[0])
        queue = deque([self.root])
        leng = len(nums)
        count = 1
        while count < leng:
            node = queue.popleft()
            if node:
                node.left = TreeNode(nums[count]) if nums[count] else None
                queue.append(node.left)
                if count + 1 < leng:
                    node.right = TreeNode(nums[count + 1]) if nums[count + 1] else None
                    queue.append(node.right)
                    count += 1
                count += 1


nums = [1, None, 2, 3]



solution = Solution()
solution.inInsert(nums) # 生成树
solution.inorder(solution.root) # 中序遍历
print(solution.traverse_path)






