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
var postorder = function(root) {
    let result = [];
    postorderTraversalFunction(root, function (value) {
        result.push(value);
    });
    return result;
};

function postorderTraversalFunction (node, callback) {
    if (node !== null) {
        if (node.children && node.children.length > 0) {
            node.children.forEach(childNode => {
                arguments.callee(childNode, callback);
            });
        }
        callback(node.val);
    }
}
