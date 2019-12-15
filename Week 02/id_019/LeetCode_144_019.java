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
        List<Integer> list=new ArrayList<Integer>();
        helper(list,root);
        return list;
    }
      public void helper(List<Integer> list,TreeNode root){
        if(root==null) return;
          list.add(root.val);
        helper(list,root.left);
        helper(list,root.right);
    }
}