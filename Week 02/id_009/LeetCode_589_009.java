import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//N叉树的前序遍历
//https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
public class LeetCode_589_009 {
    public static void main(String[] args) {
        LeetCode_589_009 test = new LeetCode_589_009();
        Node node1 = new Node(3, Arrays.asList(new Node(5, new ArrayList<>()), new Node(6, new ArrayList<>())));
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(4, new ArrayList<>());
        Node root = new Node(1, Arrays.asList(node1, node2, node3));
        System.out.println(test.preorder2(root));
    }

    /**
     * 方法一：递归法
     *
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        List<Node> children = root.children;
        if (children != null && children.size() > 0) {
            for (Node child : children) {
                helper(child, list);
            }
        }

    }

    /**
     * 方法二：迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            list.add(cur.val);
            if (cur.children.size() != 0) {
                List<Node> children = cur.children;
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }
        return list;
    }

    static class Node {
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
