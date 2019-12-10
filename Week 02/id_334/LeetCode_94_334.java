package Tree;

//Given a binary tree, return the inorder traversal of its nodes' values.
//
// Example:
//
//
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,3,2]
//
// Follow up: Recursive solution is trivial, could you do it iteratively?
// Related Topics Hash Table Stack Tree


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
class LeetCode_94_334 {


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
     * Runtime: 2 ms, faster than 56.77% of Java online submissions for Binary Tree Inorder Traversal.
     Memory Usage: 34.9 MB, less than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     */
    public List<Integer> inorderTraversalV3(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<ColorNode> stack = new Stack<ColorNode>();
        stack.push(new ColorNode(root, COLOR.WHITE));
        while (!stack.isEmpty()) {
            ColorNode node = stack.pop();
            if (node.treeNode == null) continue;
            if (node.color == COLOR.WHITE) {
                stack.push(new ColorNode(node.treeNode.right, COLOR.WHITE));
                stack.push(new ColorNode(node.treeNode, COLOR.GRAY));
                stack.push(new ColorNode(node.treeNode.left, COLOR.WHITE));
                continue;
            }
            list.add(node.treeNode.val);
        }
        return list;
    }


    /**
     * Runtime: 1 ms, faster than 56.77% of Java online submissions for Binary Tree Inorder Traversal.
     Memory Usage: 34.8 MB, less than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     */
    public List<Integer> inorderTraversalV2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
        return list;
    }


    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     Memory Usage: 34.9 MB, less than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     */
    public List<Integer> inorderTraversalV1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        recursion(root, list);
        return list;
    }

    public void recursion(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                recursion(root.left, list);
            }
            list.add(root.val);
            if (root.right != null) {
                recursion(root.right, list);
            }
        }
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)


