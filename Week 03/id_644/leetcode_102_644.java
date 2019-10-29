package week03;

import com.sun.source.tree.Tree;

import java.util.*;

/**
 *给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
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
 *
 */
public class binlevelOrder {
    public static void main(String[] args) {

    }

    //bfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> tres = new LinkedList<TreeNode>();
        TreeNode temp = root;
        tres.add(temp);
        while (!tres.isEmpty()) {
            //temp = ((LinkedList<TreeNode>) tres).pop();
            List<Integer> tmid = new ArrayList<>();
            int qsize = tres.size();
            while (qsize-- > 0) {
                temp = tres.poll();
                if (temp.left != null)
                    tres.add(temp.left);
                if (temp.right != null)
                    tres.add(temp.right);
                tmid.add(temp.val);
            }
            res.add(tmid);
        }
        return res;

    }
    //recur
    public List<List<Integer>> levelOrder_recur(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        recur(res,root,0);
        return res;
    }
    public void recur(List<List<Integer>> res,TreeNode root ,int level) {
        if(root ==null) return;
        if(res.size() <= level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        recur(res,root.left,level+1);
        recur(res,root.right,level+1);

    }



  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
