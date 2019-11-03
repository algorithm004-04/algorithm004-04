import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.sun.corba.se.impl.orbutil.graph.Node;

import javafx.beans.binding.IntegerBinding;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Easy (63.06%)
 * Likes:    58
 * Dislikes: 0
 * Total Accepted:    10.8K
 * Total Submissions: 17.2K
 * Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其层序遍历:
 *
 * [
 * ⁠    [1],
 * ⁠    [3,2,4],
 * ⁠    [5,6]
 * ]
 *
 *
 *
 *
 * 说明:
 *
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 *
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    /**
     * 层序遍历: 一层一层遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> rets = new ArrayList<>();
        if (root == null) {
            return rets;
        }
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();

            List<Integer> list = new ArrayList<>();

            while (count-- > 0) {
                Node node = queue.poll();
                list.add(node.val);
                for (Node n : node.children) {
                    queue.add(n);
                }
            }
            rets.add(list);
        }
        return rets;
    }
}
// @lc code=end
