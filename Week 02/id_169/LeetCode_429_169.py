from typing import List


class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children


class Solution:
    def levelOrder(self, root: Node) -> List[List[int]]:
        if not root:
            return []
        output, level_children = [[root.val]], root.children
        while len(level_children) > 0:
            next_level_children = []
            level_values = []
            for child in level_children:
                level_values.append(child.val)
                next_level_children += child.children
            output.append(level_values)
            level_children = next_level_children
        return output
