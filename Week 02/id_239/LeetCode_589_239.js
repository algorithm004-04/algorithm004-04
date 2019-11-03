/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
var preorder = function(root) {
    let result = [];
    preorderTraversalFunction(root, function (value) {
        result.push(value);
    });
    return result;
};

function preorderTraversalFunction (node, callback) {
    if (node !== null) {
        callback(node.val);
        if (node.children && node.children.length > 0) {
            node.children.forEach(childNode => {
                arguments.callee(childNode, callback);
            });
        }
    }
}
