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
    
    List<Integer> result = new ArrayList<>();
    
    //1递归
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     //1.recursion terminator
    //     if (root == null) return result;
    //     //2.process logic in current level
    //     inorderTraversal(root.left);
    //     result.add(root.val);
    //     //3.drill down
    //     return inorderTraversal(root.right);
    // }
    
    //2.statck
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> result = new ArrayList<>();
    //     Stack<TreeNode> stack = new Stack<>();
    //     TreeNode cur = root;
    //     while (cur != null || !stack.isEmpty()) {
    //         while (cur != null) {
    //             stack.push(cur);
    //             cur = cur.left;
    //         }
    //         cur = stack.pop();
    //         result.add(cur.val);
    //         cur = cur.right;
    //     }
    //     return result;    
    // }
    
    //3.递归
    public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<Integer>();
		inorderHelper(root, result);
		return result;
	}
    
	public void inorderHelper(TreeNode root, List<Integer> result) {
        //1.recursion terminator
		if(root==null) return;
        //2.process logic in current level
		inorderHelper(root.left, result);
		result.add(root.val);
        //3.drill down
		inorderHelper(root.right, result);
	}
    
}