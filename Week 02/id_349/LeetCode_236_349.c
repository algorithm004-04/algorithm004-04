/*
 * @lc app=leetcode.cn id=236 lang=c
 *
 * [236] 浜屽弶鏍戠殑鏈�杩戝叕鍏辩鍏?
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

// 判断 p、q 是否在当前节的左右两边，如果是，则返回当前的节点；否则进行深入左或右来进行查找
// p 是 q 的祖先，或 q 是 p 的祖先的情况也得到了考虑, 因为第一行会有可能返回 p 或 q。

struct TreeNode* lowestCommonAncestor(struct TreeNode* root, struct TreeNode* p, struct TreeNode* q) {
    if (root == NULL || root == p || root == q) 
        return root;
    struct TreeNode *left = lowestCommonAncestor(root->left, p, q);
    struct TreeNode *right = lowestCommonAncestor(root->right, p, q);
    if (left && right) 
        return root;
    return left ? left : right;
}
// @lc code=end

