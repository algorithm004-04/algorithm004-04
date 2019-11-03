'''
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
    def levelOrder(self, root):
        q, ret = [root], []
        while any(q):
            ret.append([node.get('val') for node in q])
            q = [child for node in q for child in node.get('children') if child]
        return ret

tr = {"$id":"1", "children":\
    [{"$id":"2", "children":[{"$id":"5", "children":[], "val":5}, {"$id":"6", "children":[], "val":6}], "val":2},
     {"$id":"3", "children":[], "val":3}, {"$id":"4", "children":[], "val":4}], "val":1}
tr1 = Node(tr.get("val"),tr.get("children"))
print(tr1.levelOrder(tr))

'''
def levelOrder(root):
    q, ret = [root], []
    while any(q):
        ret.append([node.get('val') for node in q])
        q = [child for node in q for child in node.get('children') if child]
    return ret

tr = {"$id":"1", "children":\
    [{"$id":"2", "children":[{"$id":"5", "children":[], "val":5}, {"$id":"6", "children":[], "val":6}], "val":2},
     {"$id":"3", "children":[], "val":3}, {"$id":"4", "children":[], "val":4}], "val":1}
print(levelOrder(tr))