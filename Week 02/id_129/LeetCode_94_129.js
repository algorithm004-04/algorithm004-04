//二叉树的中序遍历
//方法一 ：递归
var inorderTraversal = function (root) {
    if (root === null) return []
    const res = []
    function helper(node, res) {
        if (node.left) helper(node.left, res)
        res.push(node.val)
        if (node.right) helper(node.right, res)
    }
    helper(root, res)
    return res
};

//方法二：栈
var inorderTraversal = function (root) {
    if (root === null) return []
    const res = []
    let cur = root
    const stack = []
    while (cur !== null || stack.length) {
        while (cur !== null) {
            stack.push(cur)
            cur = cur.left
        }
        cur = stack.pop()
        res.push(cur.val)
        cur = cur.right
    }
    return res
};

//方法三，莫里斯遍历
var inorderTraversal = function (root) {
    if (root === null) return []
    const res = []
    let curr = root
    while (curr != null) {
        if (curr.left == null) {
            res.push(curr.val)
            curr = curr.right
        } else {
            pre = curr.left
            while (pre.right != null) {
                pre = pre.right
            }
            pre.right = curr
            let temp = curr
            curr = curr.left
            temp.left = null
        }
    }
    return res;
}
