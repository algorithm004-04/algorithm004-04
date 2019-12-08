import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
//给定一个二叉树，返回它的 前序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,2,3]
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
//https://leetcode-cn.com/problems/binary-tree-preorder-traversal/

public class LeetCode_144_009 {
    public static void main(String[] args) {
        LeetCode_144_009 test = new LeetCode_144_009();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = test.preorderTraversal2(root);
        System.out.println(list);
    }

    /**
     * 方法一：递归法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }


    /**
     * 方法二：迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }

    /**
     * 方法三：颜色标记法：(超时)
     * <p>
     * 中左右
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<List<Object>> stack = new Stack<>();
        stack.push(Arrays.asList(root, "white"));
        while (stack.size() > 0) {
            List<Object> pop = (List<Object>) stack.pop();
            TreeNode node = (TreeNode) pop.get(0);
            if ("white".equals(pop.get(1))) {
                if (root.right != null) {
                    stack.push(Arrays.asList(root.right, "white"));
                }
                if (root.left != null) {
                    stack.push(Arrays.asList(root.left, "white"));
                }
                stack.push(Arrays.asList(node, "black"));
            } else {
                res.add(node.val);
            }
        }
        return res;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
