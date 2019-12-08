class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        a = []
        if not root:
            return a
        stack = [root]
        while stack:
            curr = stack.pop()
            a.append(curr.val)
            stack.extend(curr.children)
        return a[::-1]
