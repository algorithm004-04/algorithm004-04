/*
	分析过程同 94 二叉树中序遍历的过程
*/

int treeSize(struct TreeNode *root) {
    if (root == NULL) {
        return 0;
    }
    return treeSize(root->left) + treeSize(root->right) + 1; 
}


void traversal(struct TreeNode *root,int *ret,int *num) {
    if (root == NULL) {
        return NULL;
    }
    ret[*num] = root->val;
    (*num)++;
    traversal(root->left,ret,num);
    traversal(root->right,ret,num);
}

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* preorderTraversal(struct TreeNode* root, int* returnSize){
     int size;
     size = treeSize(root);
    
    *returnSize = size;
    int *ret = malloc((size + 1) * sizeof(int));
    int num = 0;
    
    traversal(root,ret,&num);
    
    return ret;
}