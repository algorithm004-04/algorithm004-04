import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.sun.corba.se.impl.orbutil.graph.Node;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (70.27%)
 * Likes:    36
 * Dislikes: 0
 * Total Accepted:    10.9K
 * Total Submissions: 15.5K
 * Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 *
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
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
     * 后序遍历:左右中
     * 
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> rets = new ArrayList<>();
        if (root == null) {
            return rets;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            rets.add(0, node.val);// 添加到0的位置

            for (int i = 0; i < node.children.size(); i++) {
                stack.add(node.children.get(i));
            }
        }
        return rets;
    }
}
// @lc code=end
