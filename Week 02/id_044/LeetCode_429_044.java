package week_02.lesson6;

import java.util.ArrayList;
import java.util.List;

public class NAryTreeLevelOrder {


    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        level(root,0,result);
        return result;
    }

    public static void level(Node root, int i, List<List<Integer>> result) {
        if (null == root) {
            return;
        }

        if ((i + 1) > result.size()) {
            List<Integer> res = new ArrayList<>();
            result.add(res);
        }
        result.get(i).add(root.val);

        if (null != root.children) {
            for (Node node :
                    root.children) {
                level(node,i + 1,result);
            }
        }

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
        List<List<Integer>> result = levelOrder(param);
        for (List<Integer> nodes:
            result){
            System.out.println(nodes);
            /*for (Integer s :
                    nodes) {
                System.out.println(s);
            }*/
        }
    }

}
