class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root:
            return []
        self.a = [[root.val]]
        self.xun(root.children)
        return self.a
        
    def xun(self, children):
        if children:
            t = []
            r = []
            for i in children:
                r.append(i.val)
                if i.children:
                    t.extend(i.children)
            self.a.append(r)
            self.xun(t)
