import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_515_find_largest_value_in_each_tree_row {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
        在每个树行中找最大值
        BFS来解决
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largesList = new ArrayList<>();
        if (root == null) {
            return largesList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxValue = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (maxValue < node.val)
                    maxValue = node.val;

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            largesList.add(maxValue);
            maxValue = Integer.MIN_VALUE;
        }
        return largesList;
    }

}
