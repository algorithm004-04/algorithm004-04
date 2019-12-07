//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
//
// 例如:
//给定二叉树: [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层次遍历结果：
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索



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
    List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null) {
            return levels;
        }

        helper(root,0);

        return levels;

    }

    private void helper(TreeNode node, int level) {

        if(levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(node.val);

        if(node.left != null) {
            helper(node.left,level+1);
        }

        if(node.right != null) {
            helper(node.right,level+1);
        }

    }
}
//
//class Solution {
//    List<List<Integer>> levels = new ArrayList<>();
//
//    public List<List<Integer>> levelOrder(TreeNode root) {
//
//        if(root == null) {
//            return levels;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            int cnt = queue.size();
//            List<Integer> subList = new ArrayList<>();
//            for(int i = 0;i < cnt;i++) {
//                TreeNode node = queue.poll();
//                subList.add(node.val);
//                if(node.left != null) {
//                    queue.add(node.left);
//                }
//                if(node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//            levels.add(subList);
//        }
//
//        return levels;
//
//    }
//
//
//}