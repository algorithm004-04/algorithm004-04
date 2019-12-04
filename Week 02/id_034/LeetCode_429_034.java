
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_429_034 {

    // 深度优先
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrder(root, 1, list);
        return list;
    }

    private void levelOrder(Node node, int level, List<List<Integer>> list) {
        if (node == null) {
            return;
        }
        if (list.size() < level) {
            list.add(new ArrayList<>());
        }
        list.get(level - 1).add(node.val);
        for (Node child : node.children) {
            levelOrder(child, level + 1, list);
        }
    }

    /**
     * 广度优先
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int currSize = queue.size();
            List<Integer>  level = new ArrayList<>();

            for (int i = 0; i < currSize; i ++) {
                Node node = queue.poll();
                level.add(node.val);
                for (Node child : node.children) {
                    queue.add(child);
                }
            }

            list.add(level);
        }
        return list;
    }

    public static class Node {

        public int val;

        public List<Node> children;

        public Node() {
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}
