class Solution {


    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> arrayList = new ArrayList<>();
        List<Integer> array = new ArrayList<>();
        if (root != null){
            array.add(root.val);
            arrayList.add(array);
        }

        for (Node child : root.children) {
            if (child != null){
                helper(child, arrayList);
            }
        }



        return arrayList;
    }
    public void helper(Node root, List<List<Integer>>  res) {


        if (root.children != null) {
            for (Node child : root.children) {
                if (child != null){
                    preorder(child);
                }
            }

        }
    }


}