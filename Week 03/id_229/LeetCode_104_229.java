import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_104_maximum_depth_of_binarytree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //dfs
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    //dfs
    public int maxDepth_1(TreeNode root) {
        return getDepth(root, 0);
    }

    private int getDepth(TreeNode node, int level) {
        if (node == null)
            return level;
        int l = getDepth(node.left, level + 1);
        int r = getDepth(node.right, level + 1);
        return Math.max(l, r);
    }


    //bfs
    public int maxDepth1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0; //不要忘记terminator
        int level = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            level++;
        }
        return level;
    }

    //bfs   虽然感觉很鸡肋，但也是一个小思路，使用Pair类玩耍
    public int maxDepth2(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if (root == null) return 0;
        int level = 1;
        queue.add(new Pair<>(root, 1));
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                Integer current_level = pair.getValue();
                level = Math.max(current_level, level);
                if (node.left != null)
                    queue.add(new Pair<>(node.left, current_level + 1));
                if (node.right != null)
                    queue.add(new Pair<>(node.right, current_level + 1));
            }
        }
        return level;
    }

}
