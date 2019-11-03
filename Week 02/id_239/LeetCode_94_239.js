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

var inorderTraversal = function(root) {
    let result = [];
    inorderTraversalFunction(root, function(value){
        result.push(value);
    });
    return result;
};

function inorderTraversalFunction (node, callback) {
    if (node !== null) {
        arguments.callee(node.left, callback);
        callback(node.val);
        arguments.callee(node.right, callback);
    }
}
