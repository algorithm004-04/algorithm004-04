//给定一个 N 叉树，返回其节点值的后序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其后序遍历: [5,6,3,2,4,1].
//
//
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树

class Solution {
    public List<Integer> postorder(Node root) {

        List<Integer> res = new ArrayList<>();

        helper(root,res);

        return res;
    }

    private void helper(Node root, List<Integer> res) {

        if(root == null) {
            return;
        }

        if(root.children == null){
            return;
        }

        for (int i = 0; i < root.children.size(); i++) {
            helper(root.children.get(i),res);
        }

        res.add(root.val);

    }
}