import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=144 lang=java
 */

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}


/**
 * N叉树的后序遍历：同二叉树
 */
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(Node root, List<Integer> res) {
        if (root != null) {
            int s = root.children.size();
            for (int i = 0; i < s; i++) {
                helper(root.children.get(i), res);
            }
            res.add(root.val);
        }
    }


}
// @lc code=end

