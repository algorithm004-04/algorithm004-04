/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
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
        List<Integer> returnList = new ArrayList<>();
        this.transferToList(root, returnList);

        return returnList;
    }

    private void transferToList(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        this.transferToList(root.left, list);
        list.add(root.val);
        this.transferToList(root.right, list);
    }

}
