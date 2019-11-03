"""
Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example, given a 3-ary tree:
We should return its level order traversal:
[
     [1],
     [3,2,4],
     [5,6]
]

Note:
The depth of the tree is at most 1000.
The total number of nodes is at most 5000.
"""


class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children

from collections import deque

class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root:
            return []

        q, res = deque([root]), []

        while q:
            size, level = len(q), []

            for _ in range(size):
                node = q.popleft()
                level.append(node.val)
                if node.children:
                    for child in node.children:
                        q.append(child)

            res.append(level)

        return res

