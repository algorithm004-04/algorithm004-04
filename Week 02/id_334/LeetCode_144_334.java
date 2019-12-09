package Tree;

//Given a binary tree, return the preorder traversal of its nodes' values.
//
// Example:
//
//
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,2,3]
//
//
// Follow up: Recursive solution is trivial, could you do it iteratively?
// Related Topics Stack Tree


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
class LeetCode_144_334 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    class ColorNode {
        TreeNode treeNode;
        COLOR color;

        public ColorNode(TreeNode treeNode, COLOR color) {
            this.treeNode = treeNode;
            this.color = color;
        }
    }

    enum COLOR {
        WHITE,
        GRAY
    }

    /**
     * Runtime: 1 ms, faster than 61.98% of Java online submissions for Binary Tree Preorder Traversal.
     Memory Usage: 34.7 MB, less than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
     */
    public List<Integer> preorderTraversalV3(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null){
            return list;
        }
        Stack<ColorNode> stack = new Stack<ColorNode>();
        stack.push(new ColorNode(root, COLOR.WHITE));
        while (!stack.isEmpty()) {
            ColorNode node = stack.pop();
            if (node.treeNode == null) continue;
            if (node.color == COLOR.WHITE) {
                stack.push(new ColorNode(node.treeNode.right, COLOR.WHITE));
                stack.push(new ColorNode(node.treeNode.left, COLOR.WHITE));
                stack.push(new ColorNode(node.treeNode, COLOR.GRAY));
                continue;
            }
            list.add(node.treeNode.val);
        }
        return list;
    }

    /**
     * Runtime: 1 ms, faster than 61.98% of Java online submissions for Binary Tree Preorder Traversal.
     Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
     */
    public List<Integer> preorderTraversalV2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return list;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
     Memory Usage: 34.9 MB, less than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
     */
    public List<Integer> preorderTraversalV1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        recursion(root,list);
        return list;
    }

    public void recursion(TreeNode root,List<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.val);
        recursion(root.left,list);
        recursion(root.right,list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


