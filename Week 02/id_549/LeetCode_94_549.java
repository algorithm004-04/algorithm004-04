
//给定一个二叉树，返回它的中序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);

        return list;
    }

    private void helper(TreeNode root, List<Integer> result) {

        if(root != null) {

            if(root.left != null) {
                helper(root.left,result);
            }

            result.add(root.val);

            if(root.right != null) {
                helper(root.right,result);
            }

        }

    }