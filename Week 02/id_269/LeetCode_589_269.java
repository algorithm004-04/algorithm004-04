import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
589. N叉树的前序遍历

给定一个 N 叉树，返回其节点值的前序遍历。
 */
public class LeetCode_589_269 {

    /**
     * 迭代算法-使用栈完成，完成后进行顺序逆转即可
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty() && stack.peek() != null) {
            root = stack.pop();
            res.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--) {
                stack.add(root.children.get(i));
            }
        }
        return res;
    }

    /**
     * 递归算法
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        _preorder(root, res);
        return res;
    }

    public void _preorder(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                _preorder(child, res);
            }
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
