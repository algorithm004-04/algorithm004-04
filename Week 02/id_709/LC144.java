package medium;

//给定一个二叉树，返回它的 前序遍历。
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


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class LC144 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);

        root.left = right;
        right.right = right1;

        print(inorderTraversal(root));
        print(inorderTraversal_stack(root));

    }

    private static void print(List<Integer> ret) {
        System.out.println("------------------------");
        if (ret.size() == 0) {
            System.out.println("Nothing to print.");
        }
        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i));
        }
    }

    /**
     * 栈遍历
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal_stack(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr!=null||!stack.isEmpty()){
            //访问元素
            if(curr!=null){
                ret.add(curr.val);
            }
            //利用while循环将left压栈
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            //走到这里curr一定为null
            curr = stack.pop();

            curr = curr.right;
        }
        return ret;
    }


    /**
     * 前序遍历
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        traversal(root, ret);
        return ret;
    }

    /**
     * 前序遍历-递归函数
     * @param left
     * @param ret
     */
    private static void traversal(TreeNode left, List<Integer> ret) {
        if (left != null) {
            ret.add(left.val);
        }

        if(left!=null && left.left!=null){
            traversal(left.left, ret);
        }

        if(left!=null && left.right!=null){
            traversal(left.right, ret);
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
