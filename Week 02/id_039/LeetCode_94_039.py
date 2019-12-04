# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        curr = root
        pre = None
        while curr != None:
            if curr.left == None:
                res.append(curr.val)
                curr = curr.right
            else :
                pre = curr.left
                while pre.right != None:
                    pre = pre.right
                pre.right = curr
                temp = curr
                curr = curr.left
                temp.left = None
        return res

        

