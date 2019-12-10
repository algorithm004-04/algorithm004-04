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

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangchuande
 * @Date: 2019/10/20 20:37
 */
public class LeetCode_94_314 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }


    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);

        list.add(root.val);

        inOrder(root.right, list);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

