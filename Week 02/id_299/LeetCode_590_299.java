package algorithm;

import java.util.*;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class LeetCode_590_299 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,3,2,4,5,6};
        Node n = createTreaNode(arr,3);

        List<Integer> list =  postorder(n);

        for(int i : list){
            System.out.println("i----------->"+ i);
        }
    }
    public static Node createTreaNode(Integer[] array,int n){
        int len = array.length;
        if(array.length <= 0 || array[0]<0){
            return null;
        }

        Queue<Node> queue = new LinkedList<>();

        // add root
        Node root = new Node();
        root.val = array[0];
        root.children = new ArrayList<>();
        queue.add(root);

        for(int i =1; i < len && !queue.isEmpty();i += n){
            Node current = queue.poll();
            int x = (len-i);
            int m = (x / n) >= 1 ? n: x % n;
            List<Node> list = new ArrayList<>();
            for(int j = 0; j< m; j++){
                Node sub = new Node(array[i+j],new ArrayList<>());
                list.add(sub);
                queue.add(sub);
            }
            current.children = list;
        }

        return root;
    };

    /**
     * 递归
     * @param root
     * @return
     */
    public static List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root ==null) return list;
        helper(root,list);

        return list;
    }

    public static void helper(Node node, List<Integer> list){
        if(node != null){
            int len = node.children.size();
            for(int i =0;i<len;i++){
                helper(node.children.get(i),list);
            }

            list.add(node.val);
        };
    }

//    /**
//     * 迭代 广度优先
//     * @param root
//     * @return
//     */
//    public static List<Integer> postorder2(Node root) {
//        List<Integer> list = new ArrayList<>();
//        Stack<Node> stack = new Stack<>();
//
//        stack.push(root);
//        while (!stack.isEmpty()){
//            Node n = stack.pop();
//            // 拿到根节点的值
//            list.add(n.val);
//
//            // 所有的子节点入栈
//            for(Node m: n.children){
//                stack.push(m);
//            }
//        }
//        // while 得到的节点 根节点 -> 第二层子节点 -> 第三层...
//        // 翻转数组 得到 n层 -> 根节点
//        Collections.reverse(list);
//
//        return list;
//    }
}
