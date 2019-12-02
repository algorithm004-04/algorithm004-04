import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// N叉树的后序遍历
//https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/

public class LeetCode_590_009 {
    public static void main(String[] args) {
        LeetCode_590_009 test = new LeetCode_590_009();
        Node node1 = new Node(3, Arrays.asList(new Node(5, new ArrayList<>()), new Node(6, new ArrayList<>())));
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(4, new ArrayList<>());
        Node root = new Node(1, Arrays.asList(node1, node2, node3));
        System.out.println(test.postorder2(root));
    }

    /**
     * 方法一：递归法
     *
     * @param root
     * @return
     */
    public List<Integer> postorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        List<Node> children = root.children;
        if (children != null) {
            for (Node child : children) {
                helper(child, list);
            }
        }
        list.add(root.val);
    }


    /**
     * 方法二：迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> postorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        Node last = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node temp = stack.peek();
            if ((temp.children.size() == 0) || (last != null && temp.children.contains(last))) {
                list.add(temp.val);
                stack.pop();
                //更新上个指针
                last = temp;
            } else {
                //从右往左压栈
                List<Node> nodeList = temp.children;
                for (int j = nodeList.size() - 1; j >= 0; j--) {
                    stack.push(nodeList.get(j));
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

