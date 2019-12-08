import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//给定一个二叉树，返回它的中序 遍历。
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
//输出: [1,3,2]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表
// https://leetcode-cn.com/problems/binary-tree-inorder-traversal/

public class LeetCode_94_009 {
    public static void main(String[] args) {
        LeetCode_94_009 test = new LeetCode_94_009();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = test.inorderTraversal3(root);
        System.out.println(list);
    }

    /**
     * 方法一：递归法
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }


    /**
     * 方法二：迭代法
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }


    /**
     * 方法三：颜色标记法
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<List<Object>> stack = new Stack<>();
        stack.push(Arrays.asList(root, "white"));

        while (stack.size() > 0) {
            List<Object> popNode = stack.pop();
            TreeNode cur = (TreeNode) popNode.get(0);
            if ("white".equals(popNode.get(1))) {
                if (cur.right != null) {
                    stack.push(Arrays.asList(cur.right, "white"));
                }
                stack.push(Arrays.asList(cur, "black"));
                if (cur.left != null) {
                    stack.push(Arrays.asList(cur.left, "white"));
                }

            } else {
                list.add(cur.val);
            }
        }
        return list;

    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }



}
