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



//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //初始化用来返回结果的list
        List<List<Integer>> ll = new ArrayList<List<Integer>>();

        if (root == null) return ll;
        //初始化队列（层序遍历必须使用队列）
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        //定义层级遍历
        int level = 0;
        //终止条件为队列queue为空
        while (!queue.isEmpty()){
            //ll中新增一个空List，在后面的循环中往空list中添加元素
            ll.add(new ArrayList<Integer>());
            //得到每一层的元素个数
            int length = queue.size();
            //比单纯的层次遍历输出List多了一个层遍历
            for (int i =0; i < length; i++) {
                //把出队，入ll,左右子节点入队放在循环中
                TreeNode q = queue.remove();
                ll.get(level).add(q.val);
                //左右结点入队
                if (q.left != null) queue.add(q.left);
                if (q.right != null) queue.add(q.right);
            }
            level++;
        }
        return ll;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
