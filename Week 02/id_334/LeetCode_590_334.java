package Tree;

//Given an n-ary tree, return the postorder traversal of its nodes' values.
//
// For example, given a 3-ary tree:
//
//
//
//
//
//
//
// Return its postorder traversal as: [5,6,3,2,4,1].
//
//
// Note:
//
// Recursive solution is trivial, could you do it iteratively?
// Related Topics Tree


import java.util.ArrayList;
import java.util.LinkedList;
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
class LeetCode_590_334 {

    public List<Integer> postorderV2(Node root) {
        //最重要的变更就是将ArrayList改成LinkedList 同时保证 新元素在队首（顺序遍历时即为后序）
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            //注意是保证新元素放在对首
            list.addFirst(root.val);
            if (root.children != null) {
                root.children.forEach(stack::push);
            }
        }
        return list;
    }

    public List<Integer> postorderV1(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        recursion(root, list);
        return list;
    }

    public void recursion(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            root.children.forEach(n -> {
                recursion(n, list);
            });
        }
        list.add(root.val);
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


