class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res, level = [], [root]
        while root and level:
            res.append([node.val for node in level])
            level = [x for node in level for x in (node.left, node.right) if x]
        return res