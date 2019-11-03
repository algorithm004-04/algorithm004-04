/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int a[1000];
int len = 0;
int* inorderTraversal(struct TreeNode* root, int* returnSize)
{
    if (root == NULL) {
        returnSize = len;
        return a;
    }
    inorderTraversal(root->left, *returnSize);
    a[len] = root->val;
    inorderTraversal(root->left, *returnSize);
}