/*
 * @lc app=leetcode id=297 lang=javascript
 *
 * [297] Serialize and Deserialize Binary Tree
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (42.48%)
 * Likes:    2003
 * Dislikes: 99
 * Total Accepted:    228K
 * Total Submissions: 528.3K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * Example: 
 * 
 * 
 * You may serialize the following tree:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠    / \
 * ⁠   4   5
 * 
 * as "[1,2,3,null,null,4,5]"
 * 
 * 
 * Clarification: The above format is the same as how LeetCode serializes a
 * binary tree. You do not necessarily need to follow this format, so please be
 * creative and come up with different approaches yourself.
 * 
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
// v1, dfs
var serialize = function (root) {
    var traverse = function (node, arr) {
        if (!node) {
            arr.push(null)
        } else {
            arr.push(node.val.toString())
            traverse(node.left, arr)
            traverse(node.right, arr)
        }
        return arr
    }
    let arr = traverse(root, [])
    return arr.join(",")
};

// for test
// function TreeNode(val) {
//     this.val = val;
//     this.left = this.right = null;
// }

// let root = new TreeNode(1)
// let left = new TreeNode(2)
// let right = new TreeNode(3)
// right.left = new TreeNode(4)
// right.right = new TreeNode(5)
// root.left = left
// root.right = right
// let res = serialize(root)
// console.log("res: ", res)

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function (data) {
    if (!data) {
        return null
    }
    var build = function (arr) {
        let val = arr.shift()
        if (!val) {
            return null
        }
        let node = new TreeNode(val)
        node.left = build(arr)
        node.right = build(arr)
        return node
    }
    let arr = data.split(",")
    return build(arr)
};


// let tree = deserialize(res)
// console.log("tree: ", tree)
/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
// @lc code=end