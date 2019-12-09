// struct TreeNode {
//     int val;
//     struct TreeNode* left;
//     struct TreeNode* right;
// };
#include <stdio.h>
#include <stdlib.h>
#define MaxSize 1000
int** levelOrder(struct TreeNode* root,
                 int* returnSize,
                 int** returnColumnSizes) {
    if (root == NULL) {
        *returnSize = 0;
        return NULL;
    }
    struct TreeNode *qu[MaxSize], *p;  //环形队列
    int front = 0, rear = 0, k = 0, i, sum;
    int** result = (int**)malloc(sizeof(int*) * MaxSize);
    *returnColumnSizes = (int*)malloc(sizeof(int) * MaxSize);
    rear = (rear + 1) % MaxSize;
    qu[rear] = root;
    while (front != rear) {
        sum = (rear - front + MaxSize) % MaxSize;
        (*returnColumnSizes)[k] = sum;
        result[k] = (int*)malloc(sizeof(int)*sum);
        for (i = 0; i < sum; i++) {
            front = (front + 1) % MaxSize;
            p = qu[front];
            result[k][i] = p->val;
            if (p->left != NULL) {
                rear = (rear + 1) % MaxSize;
                qu[rear] = p->left;
            }
            if (p->right != NULL) {
                rear = (rear + 1) % MaxSize;
                qu[rear] = p->right;
            }
        }
        k++;
    }
    *returnSize = k;
    return result;
}
/*
作者：shi-huang-2
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/c-di-gui-die-dai-by-shi-huang-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

/*  MY BFS method*/
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
#include <stdlib.h>
#define M 1000
int** levelOrder(struct TreeNode* root,
                 int* returnSize,
                 int** returnColumnSizes) {
    int i, sum;
    struct TreeNode *qu[M];
    struct TreeNode *p;
    int **result = malloc(sizeof(int*)*M);
    int head = 0;
    int tail = 0;
    int k = 0;
    tail = (tail + 1) % M;
    qu[tail] = root;
    *returnColumnSizes = malloc(sizeof(int)*M);
    if (root == NULL) {
        *returnSize = 0;
        return NULL;
    }
    while (head != tail) {
        sum = (tail - head + M) % M;
        result[k] = malloc(sizeof(int)*sum);
        (*returnColumnSizes)[k] = sum;
        for (i = 0; i < sum; i++) {
            head = (head + 1) % M;
            p = qu[head];
            result[k][i] = p->val;
            if (p->left != NULL) {
                tail = (tail + 1) % M;
                qu[tail] = p->left;
            }
            if (p->right != NULL) {
                tail = (tail + 1) % M;
                qu[tail] = p->right;
            }
        }
        k++;
    }
    *returnSize = k;
    return result;
}