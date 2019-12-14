class Solution {

    List<Integer> arrayList = new ArrayList<>();

    public List<Integer> postorder(Node root) {


        if (root != null){

            if (root.children != null) {
                for (Node child : root.children) {
                    if (child != null){
                        postorder(child);
                    }
                }

            }
            arrayList.add(root.val);
        }
        return arrayList;
    }
}