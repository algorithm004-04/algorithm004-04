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
#include <stdlib.h>
void traversal(struct TreeNode *root, int *result, int *count)
{
    result[*count] = root->val;
    (*count)++;
    printf("%d\n",result[*count]);
    if (root->left != NULL) {
        traversal(root->left, result, count);
    }
    if (root->right != NULL) {
        traversal(root->right, result, count);
    }
}
int* preorderTraversal(struct TreeNode* root, int* returnSize){
    int *result = (int*) malloc(sizeof(int)*10000);
    int count=0;
    if (root == NULL) {
        *returnSize = 0;
        return NULL;
    }
    printf("debug begin %d\n", count);
    traversal(root, result, &count);
    *returnSize = count;
    return result;
}