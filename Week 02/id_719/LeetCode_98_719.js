/**
 * 递归
    思路
        利用递归模板
    伪代码
        递归模板
        终止： node == null
        当前层：
            node的左节点存在
            left.val 应该比 node.val 小
            node.val 应该大于 node左子树中 最右边的节点 （node.val 大于 所有左子树的值，比最大的大）

            node的右节点存在
            right.val 应该比 node.val 大
            node.val 应该小于 node 右子树中 最左侧的节点 （node.val 小于所有右子树的值， 比最小的小）

        下一层：
            下一层return false 的话，这一层返回false

        最后return true

 */

var isValidBST = function(root) {
    return _isValidBST(root);
};

function _isValidBST(node) {
    // terminator
    if (node == null) {
        return true;
    }
    // process logic
    let left = node.left;
    let right = node.right;

    if (left != null) {
        if (left.val >= node.val) return false;
        let rightest = getRightest(left);
        if (rightest && node.val <= rightest.val) return false;
    }

    if (right != null) {
        if (right.val <= node.val) return false;
        let leftest = getLeftest(right);
        if (leftest && node.val >= leftest.val) return false;
    }
    // drill down
    if (!_isValidBST(left)) {
        return false;
    }
    if (!_isValidBST(right)) return false;

    return true;
    // reverse current state
}

function getRightest(node) {
    while (node && node.right) node = node.right;
    return node;
}

function getLeftest(node) {
    while (node && node.left) node = node.left;
    return node;
}