package week_06.lesson13;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        BFS(root, result);
        return result;
    }

    public List<List<Integer>> BFS(TreeNode node, List<List<Integer>> result) {
        if (null == node) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        List<Integer> temp;
        //同一层的节点
        while (!queue.isEmpty()) {
            temp = new ArrayList<>();
            int cur = queue.size();
            for (int k = 0; k < cur; k++) {
                TreeNode nodeChild = queue.poll();
                temp.add(nodeChild.val);
                if (null != nodeChild.left) {
                    queue.add(nodeChild.left);
                }
                if (null != nodeChild.right) {
                    queue.add(nodeChild.right);
                }
            }
            result.add(temp);
        }
        return result;
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
