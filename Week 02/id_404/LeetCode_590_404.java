/*
 * @lc app=leetcode id=590 lang=java
 *
 * [590] N-ary Tree Postorder Traversal
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
    public List<Integer> postorder(Node root) {
       List<Integer> res = new ArrayList<>();
       postHelp(root, res);

       return res;
    }
    private void postHelp(Node root, List<Integer> res) {
        if (root == null) return;
        for (Node cur: root.children) {
            postHelp(cur, res);
        }
        res.add(root.val);
    }

    public List<Integer> postorder2(Node root) {
       List<Integer> res = new ArrayList<>();
       if (root == null) return res;

       Stack<Node> stack = new Stack<>();
       stack.push(root);
       while (!stack.isEmpty()) {
           root = stack.pop();
           res.add(root.val);
           for (Node node: root.children) stack.add(node);
       }
       Collections.reverse(res);

       return res;
    }
}
// @lc code=end
