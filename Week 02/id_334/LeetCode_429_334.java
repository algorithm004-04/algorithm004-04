package Tree;

//Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
// For example, given a 3-ary tree:
//
//
//
//
//
//
//
// We should return its level order traversal:
//
//
//[
//     [1],
//     [3,2,4],
//     [5,6]
//]
//
//
//
//
// Note:
//
//
// The depth of the tree is at most 1000.
// The total number of nodes is at most 5000.
//
// Related Topics Tree Breadth-first Search


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};

//bfs广度优先 level递归 或 双端队列（先进先出）
//dfs深度优先 前序+中序+后序 -》栈（后进先出）- 反序 或 递归 - 正序
*/
class LeetCode_429_334 {


    public List<List<Integer>> levelOrderV2(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        //采用FIFO策略，利用count记录每层节点总数 -> 将每层节点的子集按从左到右顺序入队，利用count进行层级划分
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        while (queue.size() != 0) {
            List<Integer> arrayList = new ArrayList<>();
            //使用count记录每层的节点总数
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                root = queue.pollFirst();
                if (root.children != null) {
                    root.children.forEach(queue::addLast);
                }
                arrayList.add(root.val);
            }
            list.add(arrayList);
        }
        return list;
    }

    public List<List<Integer>> levelOrderV1(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        recursion(root, list, 1);
        return list;
    }

    public void recursion(Node root, List<List<Integer>> list, int level) {
        if (root == null) return;
        //最重要的判断 - 用于是否新增层级数组
        if (list.size() < level) {
            list.add(new ArrayList<>());
        }
        list.get(level - 1).add(root.val);
        if (root.children != null) {
            root.children.forEach(n -> {
                recursion(n, list, level + 1);
            });
        }
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

    ;
}
//leetcode submit region end(Prohibit modification and deletion)


