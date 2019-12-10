import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
590. N叉树的后序遍历

后序遍历的迭代算法本来的顺序是左-右-中
使用栈解法，可以变换为中-右-左 右在前的前序遍历
 */
public class LeetCode_590_269 {

    /**
     * 迭代算法-使用栈完成，完成后进行顺序逆转即可
     */
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty() && stack.peek() != null) {
            root = stack.pop();

            res.add(root.val);
            stack.addAll(root.children);
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 递归算法
     */
    public List<Integer> postorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        _postOrder(root, res);
        return res;
    }

    public void _postOrder(Node root, List<Integer> res) {
        if (root == null) return;
        if (root.children != null) {
            for (Node child : root.children) {
                _postOrder(child, res);
            }
        }

        res.add(root.val);
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
