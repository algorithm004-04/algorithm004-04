package algorithm;

import java.util.*;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_94_299 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, null, 2, 3};
        TreeNode tree = createTreaNode(array);
        List<Integer> list = inorderTraversal(tree);

        for (int i : list){
            System.out.println("前序遍历--------------->"+i);
        }
    }
    public static TreeNode createTreaNode(Integer[] array){
        int len = array.length;
        if(array.length <= 0 || array[0]<0){
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

    /**
     * 方法1
     * 递归的方式
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root!=null){
            helper(root,list);
        };

        return list;
    }

    public static void helper(TreeNode root, List<Integer> list){
        // 遍历左节点
        if(root.left!=null){
            helper(root.left,list);
        }
        list.add(root.val);
        if(root.right!=null){
            helper(root.right,list);
        }
    }

    /**
     * 方法二
     * 入栈的方式
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack <>();

        TreeNode current = root;
        while(current!= null || !stack.isEmpty()){
            // 左子节点循环入栈
            while(current != null){
                stack.push(current);
                current =current.left;
            }
            // 一直没有左子节点,取后入栈的值
            current = stack.pop();
            // 把该node的值存入数组中
            list.add(current.val);
            // 循环完左子节点开始 找右节点
            current = current.right;
        }

        return list;
    }
}
