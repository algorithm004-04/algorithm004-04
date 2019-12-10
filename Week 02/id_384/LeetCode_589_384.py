# 递归：
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        self.a = []
        self.xun(root)
        return self.a
        
    def xun(self, root):
        if root:
            self.a.append(root.val)
            for i in root.children:
                self.xun(i)

# 迭代：
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        a = []
        if not root:
            return a
        stack = [root]
        while stack:
            curr = stack.pop()
            a.append(curr.val)
            v = curr.children
            stack.extend(v[::-1])
        return a
