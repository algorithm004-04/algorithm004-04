package algorithm;

import java.util.*;

/**
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_144_299 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, null, 2, 3};
        TreeNode tree = createTreaNode(array);
        List<Integer> list = preorderTraversal(tree);

        for (int i : list){
            System.out.println("前序遍历--------------->"+i);
        }
    }

    public static TreeNode createTreaNode(Integer[] array){
        int len = array.length;
        if(len <= 0 || array[0]<0){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        // add root
        TreeNode root = new TreeNode(array[0]);
        queue.add(root);

        for(int i =1; i < len && !queue.isEmpty();i += 2){
            TreeNode current = queue.poll();
            if(array[i] != null){
                current.left = new TreeNode(array[i]);
                queue.add(current.left);
            }
            if(i!= (len-1) && array[i+1] != null){
                current.right = new TreeNode(array[i+1]);
                queue.add(current.right);
            }
        }
        return root;
    };

    // 前序遍历
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        helper(root,list);
        return list;
    }

    public static void helper(TreeNode node, List<Integer> list){
        if(node == null) return;
        list.add(node.val);
        helper(node.left,list);
        helper(node.right,list);
    }


    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        while (current!=null || !stack.isEmpty()){
            while (current!=null){
                list.add(current.val);
                stack.push(current);
                current = current.left;
            }
            current = stack.pop().right;
        }

        return list;
    }
}
