/*
 *    二叉树的中序遍历 
 *    https://leetcode-cn.com/problems/binary-tree-inorder-traversal/ 
 *
*/

#include <vector>
#include <iostream>
#include <stack>

using namespace std:

/**
 * Definition for a binary tree node.
 */
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    /*
        方法一：使用堆栈迭代 

        时间复杂度：O(n) 
        空间复杂度: O(n)
    */
    vector<int> inorderTraversal_1(TreeNode* root) {
        vector<int> ret;
        stack<TreeNode*> st;

        while (root || !st.empty()){
            while (root){
                st.push(root);
                root = root -> left;
            }

            root = st.top();
            st.pop();
            ret.push_back(root -> val);
            root = root -> right;
        }

        return ret;
    }

    /*
        方法二：递归 

        时间复杂度：O(n) 
        空间复杂度: O(n)
    */
    vector<int> inorderTraversal_2(TreeNode* root) {
        vector<int> ret;
        inorder(root, ret);
        return ret;
    }

    /*
        方法三：莫里斯遍历 (Morris traversal)

        线索二叉树
        二叉树的遍历本质上是将一个复杂的非线性结构转换为线性结构，使每个结点都有了唯一前驱和后继（第一个结点无前驱，最后一个结点无后继）。
        对于二叉树的一个结点，查找其左右子女是方便的，其前驱后继只有在遍历中得到。为了容易找到前驱和后继，有两种方法。
        一是在结点结构中增加向前和向后的指针，这种方法增加了存储开销，不可取；二是利用二叉树的空链指针。        

           1
         /   \
        2     3
       / \   /
      4   5 6

         2
        / \
       4   5
       
         2
        / \
       4   5
            \
             1
              \
               3
              /
             6

        4
         \
          2
           \
            5
             \
              1
               \
                3
               /
              6

        4
         \
          2
           \
            5
             \
              1
               \
                3
                 \
                  6

        时间复杂度：O(n) 
        空间复杂度: O(1)
    */
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> ret;

        while (root) {
            if (root -> left){
                TreeNode* pre = root -> left;

                while (pre -> right && pre -> right != root) {
                    pre = pre -> right;
                }

                if (!pre -> right) {
                    pre -> right = root;
                    root = root -> left;
                } else {
                    pre -> right = NULL;
                    ret.push_back(root -> val);
                    root = root -> right;
                }

            }else{
                ret.push_back(root -> val);
                root = root -> right;
            }
        }

        return ret;
    }

private:
    void inorder(TreeNode* root, vector<int>& nodes){
        if (!root)
            return;
        
        inorder(root -> left, nodes);
        nodes.push_back(root -> val);
        inorder(root -> right, nodes);
    }
};

