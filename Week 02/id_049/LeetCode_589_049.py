class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children

class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if root is None:
            return []
        stack = [root]
        out = []
        while stack:
            temp = stack.pop()
            out.append(temp.val)
            if temp.children:
                for item in temp.children[::-1]:
                    stack.append(item)
        return out
