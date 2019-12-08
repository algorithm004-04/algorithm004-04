import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
144. 二叉树的前序遍历
给定一个二叉树，返回它的 前序 遍历。

 */
public class LeetCode_144_269 {

    /**
     * 迭代算法
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode item = stack.pop();

            if (item != null) {
                res.add(item.val);
                stack.push(item.right);
                stack.push(item.left);
            }
        }
        return res;
    }

    /**
     * 递归算法
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
