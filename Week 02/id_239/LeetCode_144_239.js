/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal = function(root) {
    let result = [];
    preorderTraversalFunction(root, function (value) {
        result.push(value);
    });
    return result;
};

function preorderTraversalFunction (node, callback) {
    if (node !== null) {
        callback(node.val);
        arguments.callee(node.left, callback);
        arguments.callee(node.right, callback);
    }
}
