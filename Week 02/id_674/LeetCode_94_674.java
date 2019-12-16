class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
		travers(root, list);
		return list;
    }
    
    public void travers(TreeNode root, List<Integer> list) {

		if (root != null) {
			if (root.left != null) {
				travers(root.left, list);
			}
			list.add(root.val);
			if (root.right != null) {
				travers(root.right, list);
			}

		}
	}
}