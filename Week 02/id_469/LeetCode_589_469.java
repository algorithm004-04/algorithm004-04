import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
 */

// @lc code=start
/*
 * // Definition for a Node.
 */

// class Node {
// public int val;
// public List<Node> children;

// public Node() {
// }

// public Node(int _val, List<Node> _children) {
// val = _val;
// children = _children;
// }
// };


class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(Node root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            int s = root.children.size();
            for (int i = 0; i < s; i++) {
                helper(root.children.get(i), res);
            }
        }
    }
}
// @lc code=end

