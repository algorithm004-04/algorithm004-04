/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList<>();
       inorderHelper(root, res);
       return res;
    }
    private void inorderHelper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left != null) inorderHelper(root.left, res);
        res.add(root.val);
        if (root.right != null) inorderHelper(root.right, res);
    }
    public List<Integer> inorderTraversal2(TreeNode root) {
       List<Integer> res = new ArrayList<>();
       Stack<TreeNode> stack = new Stack<>();
       TreeNode cur = root;

       while (cur != null || !stack.isEmpty()) {
           while (cur != null) {
               stack.push(cur);
               cur = cur.left;
           }
           cur = stack.pop();
           res.add(cur.val);
           cur = cur.right;
       }
       return res;
    }
}
// @lc code=end
