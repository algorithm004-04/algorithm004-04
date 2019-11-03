class Solution {

    List<Integer> arrayList = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {


        if (root != null){
            arrayList.add(root.val);
            if (root.left != null){
                preorderTraversal(root.left);
            }
            if (root.right != null){
                preorderTraversal(root.right);
            }
        }
        return arrayList;

    }
}