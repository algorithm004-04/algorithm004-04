/*
	切题四件套:
	
	1. 分析题意，查看是否有需要注意的地方
	
	2. 思考更多的解法，选择最合适的解法进行解决和处理 时间复杂度和空间复杂度都比较小的解法

	3. Code
	
	4. test case

	
	1. 这道题是二叉树的中序遍历，首先想到的是递归
	
	2. 迭代也可以进行解决，利用栈进行解决
	
	
	中序遍历: 
			左遍历
			元素节点
			右遍历
	对于C语言来说最难的在于如何把它放入到数组中进行返回了
	
	自己写的时候一直是堆栈溢出，也不知道怎么做，最后参考了国际站的一个c代码，代码逻辑非常的清晰，有兴趣的话也可以看一下，将不同的功能放到不同的函数中，同时使用了全局变量，使用全局变量的时候你需要在调用的函数中也初始化一下
	不然leetcode提交的时候会提示Runtime Error的
	
	同时也验证了一下老师的想法：
		做一遍是不够的
		这道题自己以前做过一次，现在这次写没有写出来
*/

// 方法1  Refer from https://leetcode.com/problems/binary-tree-inorder-traversal/discuss/31315/0ms-C-solution-use-recursion-and-global-variable

int gsize=0;
int treeSize(struct TreeNode *root) {
    if (root == NULL) {
        return 0;
    }
    return treeSize(root->left) + treeSize(root->right) + 1;
}

void push(int val,int *ret) {
    ret[gsize] = val;
    gsize++;
}

void travelsal(struct TreeNode *root,int *ret) {
     if (!root) {
         return;
     } 
    // 左
    travelsal(root->left,ret);
    // 放入到数组中
    push(root->val,ret);
    // 右
    travelsal(root->right,ret);
}

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* inorderTraversal(struct TreeNode* root, int* returnSize){
   int size;
   size = treeSize(root);
   *returnSize = size;
   int *ret = malloc((size+1) * sizeof(int));
   gsize = 0;
   travelsal(root,ret);
   return ret;
}

// 方法2，如果不适用全局变量，可不可以自己代码里面维护一个变量呢， 适用num替换了全局变量，当然我们也可以将 returnSize 传过去适用 returnSize
int treeSize(struct TreeNode *root) {
    if (root == NULL) {
        return 0;
    }
    return treeSize(root->left) + treeSize(root->right) + 1;
}

void travelsal(struct TreeNode *root,int *ret,int *num) {
     if (!root) {
         return;
     } 
     
    // 左
    travelsal(root->left,ret,num);
    // 放入到数组中
    ret[*num] = root->val;
    (*num)++;
    // 右
    travelsal(root->right,ret,num);
}

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* inorderTraversal(struct TreeNode* root, int* returnSize){
   int size;
   size = treeSize(root);
  *returnSize = size;
   int *ret = malloc((size+1) * sizeof(int));
   int num = 0;
   travelsal(root,ret,&num);
    
    return ret;
}

// 3. 适用栈空间来模拟进行，适用链式栈进行维护栈的结构，栈的结构还需要保存 树节点的指针，这一点现在功力还不够，先放一下，下面的程序是有报错的

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

typedef struct stackNode{
    strcut TreeNode *data;
    struct stackNode *next;
}stackNode,*linkStackPtr;

typedef struct {
    linkStackPtr top;
    int count;
}linkStack;


int treeSize(struct TreeNode *root) {
    
    if (root == NULL) {
        return 0;
    }
    
    return treeSize(root->left) + treeSize(root->right) + 1;
}

void init(linkStack *s) {
    s->top = malloc(sizeof(stackNode));
    s->count = 0;
    s->top = null;
}

struct TreeNode* pop(linkStack *s,struct TreeNode *e) {
    e = s->top->data;
    s->top = s->top->next;
    s->count--;
    return e;
}

void push(linkStack *s,struct TreeNode *e) {
    linkStackPtr *p;
    p = malloc(siezof(stackNode));
    p->data = e;
    p->next = s->top;
    s->top = p;
    s->count++;
}

bool isEmpty(linkStack s) {
    if (s.count == 0) {
        return true;
    }
    return false;
}


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* inorderTraversal(struct TreeNode* root, int* returnSize){
    int size;
    size = treeSize(root);
    *returnSize = size;
    
    int *ret = malloc((size + 1) * sizeof(int));
    linkStack s;
    
    init(&s);
    struct TreeNode *curr;
    curr = root;
    
    int num;
    int cursor = 0;
    while (curr || !isEmpty(s)) {
            while(curr) {
                push(s,curr);
                curr = curr->left;
            }
            curr = pop(s);
            ret[cursor++] = curr->val;
            cur = cur->right;
    }
    return ret;
}

