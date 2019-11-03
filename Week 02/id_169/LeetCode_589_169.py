from typing import List


class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children


class Solution:
    def preorder(self, root: Node) -> List[int]:
        if not root:
            return []
        nodes = [root.val]
        for node in root.children:
            nodes += self.preorder(node)
        return nodes