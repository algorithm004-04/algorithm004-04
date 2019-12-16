"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        
        res = []
        self.mid_loop(root, res)
        return res
    
    def mid_loop(self, root: 'Node',res_list: List[int]) -> List[int]:
        if root:
            res_list.append(root.val)

            if root.children:
                for i in root.children:
                    self.mid_loop(i, res_list)

    