class Solution:

    def __init__(self):
        self.ans = None

    def lowestCommonAncestor(self, root, p, q):
        def recurse_tree(current_node):
            if not current_node:
                return False
            left = recurse_tree(current_node.left)
            right = recurse_tree(current_node.right)
            mid = current_node == p or current_node == q
            if mid + left + right >= 2:
                self.ans = current_node
            return mid or left or right
        recurse_tree(root)
        return self.ans
