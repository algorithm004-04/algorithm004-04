/*
 * @lc app=leetcode.cn id=236 lang=c
 *
 * [236] 二叉树的最近公共祖�?
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

// �ж� p��q �Ƿ��ڵ�ǰ�ڵ��������ߣ�����ǣ��򷵻ص�ǰ�Ľڵ㣻���������������������в���
// p �� q �����ȣ��� q �� p �����ȵ����Ҳ�õ��˿���, ��Ϊ��һ�л��п��ܷ��� p �� q��

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

