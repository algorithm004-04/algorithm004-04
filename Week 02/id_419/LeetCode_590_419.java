package main.week.week02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ybh on 2019/10/28.
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 */
public class LeetCode_590_419 {

    List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if(root==null){
            return result;
        }
        List<Node> childrenList = root.children;
        if(childrenList!=null && childrenList.size()>0){
            for(Node node : childrenList){
                postorder(node);
            }
        }

        result.add(root.val);

        return result;
    }
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {

    }

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
