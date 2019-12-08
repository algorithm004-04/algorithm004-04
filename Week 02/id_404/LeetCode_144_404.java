/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList<>();
       preHelper(root, res);

       return res;
    }
    private void preHelper(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        preHelper(node.left, res);
        preHelper(node.right, res);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> tovisit = new Stack<>();
        tovisit.add(root);
        while(!tovisit.isEmpty()) {
            TreeNode visiting = tovisit.pop();
            res.add(visiting.val);
            if (visiting.right != null) tovisit.add(visiting.right);
            if (visiting.left != null) tovisit.add(visiting.left);
        }

        return res;
    }
}
// @lc code=end
