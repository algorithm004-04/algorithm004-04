package Tree;

//Given an n-ary tree, return the preorder traversal of its nodes' values.
//
// For example, given a 3-ary tree:
//
//
//
//
//
//
//
// Return its preorder traversal as: [1,3,5,6,2,4].
//
//
//
// Note:
//
// Recursive solution is trivial, could you do it iteratively?
// Related Topics Tree


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
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
class LeetCode_589_334 {


    /**
     * Runtime: 3 ms, faster than 37.84% of Java online submissions for N-ary Tree Preorder Traversal.
     Memory Usage: 49.5 MB, less than 9.76% of Java online submissions for N-ary Tree Preorder Traversal.
     */
    public List<Integer> preorderV2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (root.children != null) {
                for (int i = root.children.size() - 1; i >= 0; i--) {
                    stack.push(root.children.get(i));
                }
            }
        }
        return list;
    }


    /**
     * Runtime: 33 ms, faster than 18.31% of Java online submissions for N-ary Tree Preorder Traversal.
     * Memory Usage: 48.2 MB, less than 19.51% of Java online submissions for N-ary Tree Preorder Traversal.
     */
    public List<Integer> preorderV1(Node root) {
        List<Integer> list = new ArrayList<>();
        recursion(root, list);
        return list;
    }

    public void recursion(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.children != null) {
            root.children.forEach(n -> {
                recursion(n, list);
            });
        }
    }


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
}
//leetcode submit region end(Prohibit modification and deletion)


