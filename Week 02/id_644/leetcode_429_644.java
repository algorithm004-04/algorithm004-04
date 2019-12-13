package com.company;
/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *  
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelorder {
    public static void main(String[] args) {

    }
    // stack method
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> queue  = new LinkedList<>();
        queue.add(root);
        Node cur = root;
        while( !queue.isEmpty() ) {
            List<Integer> temp = new ArrayList<>();
            int s = queue.size();
            while(s-- > 0) {
                cur = queue.poll();
                temp.add(cur.val);
                for(Node n1 : cur.children) {
                    if(n1 != null)
                        queue.add(n1);
                }

            }
            res.add(temp);
        }
        return res;

    }

    //recur
    public List<List<Integer>> levelOrder_recur(Node root) {

        return recur(root,0, new ArrayList<>());
    }
    public List<List<Integer>> recur(Node root, int depth, List<List<Integer>> res) {
        if (root == null) return res;
        List<Integer> temp  = res.size() > depth ? res.get(depth): new ArrayList<>();
        temp.add(root.val);
        if(res.size() <= depth)
            res.add(temp);
        for(Node n1 : root.children) {
            recur(n1,depth+1,res);
        }
        return res;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
