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
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
         List<List<Integer>> result = new ArrayList<>();
        if( root == null ){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while( !queue.isEmpty() ){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for( int i=0; i<size; i++){
                Node node = queue.poll();
                temp.add(node.val);
                List<Node> children = node.children;
                if( children!= null && children.size() > 0){
                    for( Node n : children){
                        queue.add(n);
                    }
                }
            }
            result.add(temp);
        }
        return result;
    }
}