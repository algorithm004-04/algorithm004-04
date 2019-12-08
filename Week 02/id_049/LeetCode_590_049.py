# 说明: 递归法很简单，你可以使用迭代法完成此题吗?
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children

class Solution:
# 非递归
    def postorder(self, root: 'Node') -> List[int]:
        if root is None:return []
        res = []
        queue = [root]
        while queue:
            temp = queue.pop()
            res.append(temp.val)
            if temp.children:
                for item in temp.children:
                    queue.append(item)
        return res[::-1]

# 递归
    def postorder(self, root: 'Node') -> List[int]:
        if root is None: return []
        def search(Root):
            for i in Root.children:
                if i:
                    search(i)
                    self.stack.append(i.val)
        self.stack = []
        search(root)
        self.stack.append(root.val)
        return self.stack