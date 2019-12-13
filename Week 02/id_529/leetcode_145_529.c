
 // Definition for a binary tree node.
 typedef struct TreeNode {
      int val;
      struct TreeNode *left;
      struct TreeNode *right;
  }treeNode;
 


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
void traversal(struct TreeNode* root, int *result, int *count)
{
    if (root->left != NULL) {
        traversal(root, result, count);
    }
    if (root->right != NULL) {
        traversal(root, result, count);
    }
    result[*count] = root->val;
    (*count)++;
}
int* postorderTraversal(struct TreeNode* root, int* returnSize){
    int *result = (int*)malloc(sizeof(int)*5000);
    int count = 0;
    if (root == NULL) {
        *returnSize = 0;
        return NULL;
    }
    traversal(root, result, &count);
    *returnSize = count;
    return result;
}

void main()
{
    treeNode *root = (treeNode*)malloc()
    
}