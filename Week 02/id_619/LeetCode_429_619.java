class Solution {
    public List<List<Integer>> levelOrder(Node root) {
         List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        int count = queue.size();
        //外层循环为一层
        List<Integer> list = new ArrayList<>();
        while (count-- > 0) {
            //将当前元素的非空子节点压入栈
            Node cur = queue.poll();
            list.add(cur.val);
            for (Node node : cur.children) {
                if (node != null) {
                    queue.add(node);
                }
            }
        }
        res.add(list);
    }
    return res;
    }
}