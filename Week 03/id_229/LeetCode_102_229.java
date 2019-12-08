import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_102_level_order_traversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
        二叉树层序遍历：
        1、DFS这里也是树的前序遍历
        2、BFS

        注意点：
        1、可将levelOrderList当成形式参数来进行传递，当方法销毁内存也就会回收
        2、DFS的levelOrderList.add(new ArrayList<>());时机问题
        3、BFS的过程中需要因为题目的原因需要while (!queue.isEmpty())判断每次都将queue里面的内容进行清空掉
     */

    List<List<Integer>> levelOrderList = new ArrayList<>();

    //二叉树的层次遍历
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) return levelOrderList;
        helper(root, 0);
        return levelOrderList;
    }

    private void helper(TreeNode node, int level) {
        if (levelOrderList.size() == level) //因为这个是DFS所以就直接这样写就可以
            levelOrderList.add(new ArrayList<>()); //与上同理

        levelOrderList.get(level).add(node.val);

        if (node.left != null) //有了这判断就不需要加terminator
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);

    }


    //二叉树的层次遍历
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) { // 主要还是思想：根据题意的输出形式，需要外层添加一个while循环来加入level值
            int queueSize = queue.size();
            levels.add(new ArrayList<>());
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                levels.get(level).add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            level++;
        }
        return levels;
    }

}
