class Solution {

    List<Integer> arrayList = new ArrayList<>();
    public List<Integer> preorder(Node root) {


        if (root != null){
            arrayList.add(root.val);
            if (root.children != null) {
                for (Node child : root.children) {
                    if (child != null){
                        preorder(child);
                    }
                }

            }
        }
        return arrayList;

    }
}