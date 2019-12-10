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
    
    //1递归
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     //recursion terminator
    //     if(root == null || root == p || root == q) return root;
    //     //process logic in current level
    //     TreeNode left = lowestCommonAncestor(root.left, p, q);
    //     TreeNode right = lowestCommonAncestor(root.right, p, q);
    //     //drill down
    //     return left == null ? right : right == null ? left : root;
    // }
    
    //2stack
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     Stack<TreeNode> pstack = new Stack();
    //     Stack<TreeNode> qstack = new Stack();
    //     if(hasPath(root, p, pstack) && hasPath(root, q, qstack)) {
    //         while(pstack.size() > 0 && qstack.size() > 0) {
    //             TreeNode curNode = pstack.pop();
    //             for(int i = qstack.size() - 1 ; i >= 0 ; i--) {
    //                 if(qstack.get(i) == curNode) {
    //                     return qstack.get(i);
    //                 }
    //             }
    //         }
    //     }
    //     return root;
    // }
    // public boolean hasPath(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
    //     //recursion terminator
    //     if(root == null) {
    //         return false;
    //     }
    //     //process logic in current level
    //     stack.push(root);
    //     //drill down
    //     if(root.val == node.val) {
    //         return true;
    //     }
    //     if(hasPath(root.left, node, stack) || hasPath(root.right, node, stack)) {
    //         return true;
    //     }
    //     stack.pop();
    //     return false;
    // }
    
    //3
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return Lca(root, p, q);
    }
    public TreeNode Lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else if (root == p || root == q) {
            return root;
        }

        TreeNode leftLca  = Lca(root.left, p, q);
        TreeNode rightLca = Lca(root.right, p, q);

        if (leftLca == null) {
            return rightLca;
        } else if (rightLca == null) {
            return leftLca;
        } else {
            return root;
        }
    }
}