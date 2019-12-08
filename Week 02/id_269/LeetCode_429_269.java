import java.util.*;

/*
429. N叉树的层序遍历

给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

层序遍历的核心思想就是加入队列中，每一层出队的时候再将孩子节点加入到队列中。
每一层出队之前记录一下当前level的size有多大，这样能够保证出队不会将当前孩子节点出队。
 */
public class LeetCode_429_269 {

    /**
     * 层序遍历是BFS，使用队列即可完成
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty() && queue.peek() != null) {
            //这一层一共有多少个元素
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            while (size-- > 0) {
                //最多移除 size次就可以了
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            res.add(level);
        }
        return res;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
