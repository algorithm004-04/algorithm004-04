class TreeNode:
    def __init__(self, x, chlidren):
        self.val = x
        self.chlidren = chlidren


def postorder(root: 'Node'):        # 这个解题方式，还不理解是什么意思
    if root == None:
        return []
    res = []
    stack = [root]
    while stack:
        root = stack.pop()
        if root is not None:
            res.append(root.val)
        for i in root.children:
            stack.append(i)
            
    return res[:: -1]
