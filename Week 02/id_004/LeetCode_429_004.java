import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        ArrayDeque<Node> deque = new ArrayDeque<Node>();
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){ return  result;}
        deque.addLast(root);

        while (!deque.isEmpty()){

            int levelCount = deque.size();
            List<Integer> levelResult = new ArrayList<>();


            while (levelCount > 0){
                Node node = deque.pollFirst();
                levelResult.add(node.val);
                for (Node child : node.children) {
                    deque.addLast(child);
                }
                --levelCount;
            }

            result.add(levelResult);


        }

        return result;


    }
}