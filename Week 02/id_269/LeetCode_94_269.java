import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
94. 二叉树的中序遍历

中序遍历对于BST来说就是顺序输出所有元素

迭代算法，需要栈来辅助操作。先将所有元素入栈
 */
public class LeetCode_94_269 {

    /**
     * 迭代算法
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            //所有的左节点都压入栈了
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            //到这里左节点到末尾了，需要出栈一个元素
            TreeNode item = stack.pop();
            res.add(item.val);

            //下一轮循环需要将出栈元素的右子树入栈
            root = item.right;
        }
        return res;
    }

    /**
     * 递归算法
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
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
