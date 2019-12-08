//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其层序遍历:
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
//
//
//
//
// 说明:
//
//
// 树的深度不会超过 1000。
// 树的节点总数不会超过 5000。
// Related Topics 树 广度优先搜索

class Solution {
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();

        helper(root,0,res);

        return res;

    }

    private void helper(Node root, int depth, List<List<Integer>> res) {

        if(root == null) {
            return;
        }

        if(depth + 1 > res.size()) {
            res.add(new ArrayList<>());
        }

        res.get(depth).add(root.val);

        for (int i = 0; i < root.children.size(); i++) {
            helper(root.children.get(i),depth+1,res);
        }

    }
}