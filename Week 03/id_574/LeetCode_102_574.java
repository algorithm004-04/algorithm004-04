package SuanFa.Week03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_102_574 {

    public static List<List<Integer>> levels = new ArrayList<>();
    public static void main(String[] args) {


    }

    /**
     * 递归
     * @param root
     * @return
     */
    private List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root,0);
        return levels;
    }

    private void helper(TreeNode node, int level) {
        if (levels.size() == level) levels.add(new ArrayList<>());
        levels.get(level).add(node.val);
        if (node.left != null) helper(node.left,level+1);
        if (node.right != null) helper(node.right,level+1);
    }

    /**
     * 用队列
     */

    private List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> levels1 = new ArrayList<>();
        if (root == null) return levels1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while ( !queue.isEmpty()) {
            levels1.add(new ArrayList<>());
            for (int i=0;i<queue.size();i++) {
                TreeNode node = queue.remove();
                levels1.get(level).add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }
        return levels1;
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
