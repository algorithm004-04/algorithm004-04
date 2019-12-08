package week_02.lesson6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NAryTreePostorder {

    static List<Integer> result = new ArrayList<>();

    public static List<Integer> postorder(Node root) {

        if (null == root) {
            return new ArrayList<>(0);
        }

        if (null != root.children) {
            for (Node node : root.children) {
                postorder(node);
            }
        }

        result.add(root.val);
        return result;

    }

    public static void main(String[] args) {
        List<Node> firstChildren = new ArrayList<>(3);
        List<Node> secondChildren = new ArrayList<>(2);
        secondChildren.add(new Node(5,null));
        secondChildren.add(new Node(6,null));
        firstChildren.add(new Node(3,secondChildren));
        firstChildren.add(new Node(2,null));
        firstChildren.add(new Node(4,null));
        Node param = new Node(1,firstChildren);
        List<Integer> r = postorder(param);
        System.out.println(r.size());
        for (int i : r) {
            System.out.println(i);
        }
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
