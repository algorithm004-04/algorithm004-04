class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children

class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root:return []
        queue=[(0,root)]
        res=[]
        while queue:
            level,node=queue.pop(0)
            print(level)
            print(len(res))
            print("-----")
            if len(res) == level:
                res.append([node.val])
            else:
                res[level].append(node.val)
                print("here")
                print("=====")
            if node.children:
                for i in node.children:
                    queue.append((level+1,i))
        return res

    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if root is None: return []
        res = []
        def traverse(node, level):
            if node:
                if len(res) == level:
                    res.append([])
                res[level].append(node.val)

                if node.children:
                    for child in node.children:
                        traverse(child, level + 1)
        traverse(root, 0)
        return res
