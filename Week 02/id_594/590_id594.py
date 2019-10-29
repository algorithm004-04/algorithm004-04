class TreeNode:
    def __init__(self, x, chlidren):
        self.val = x
        self.chlidren = chlidren


def postorder(root: 'Node'):        # 这个解题方式，还不理解是什么意思
    res = []

    if root == None:
        return res

    stack = [root]
    while stack:
        temp = stack.pop()
        res.append(temp.val)
        stack.extend(temp.chlidren)
    return res[:: -1]
