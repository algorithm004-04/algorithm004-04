/*
 * @lc app=leetcode.cn id=515 lang=c
 *
 * [515] 在每个树行中找最大�?
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


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#define SIZE 1000
void DFS(struct TreeNode* root, int *ret, int height, int* returnSize) {
    if (root == NULL) return ;
    if (*returnSize <= height) { 
        *returnSize = height + 1;
        ret[height] = root->val;
    }
    else if (ret[height] < root->val) {
        ret[height] = root->val;
    }
    DFS(root->left, ret, height + 1, returnSize);
    DFS(root->right, ret, height + 1, returnSize);
}

int* largestValues(struct TreeNode* root, int* returnSize) {
    int *ret = (int*)malloc(sizeof(int) * SIZE);
    int height = 0;
    *returnSize = 0;
    DFS(root, ret, height, returnSize);
    return ret;
}

// @lc code=end

