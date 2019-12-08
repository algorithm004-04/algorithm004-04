#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <assert.h>
using namespace std;

//LeetCode 429 N叉树的层序遍历
//N叉树的层序遍历---广度优先遍历，借助队列
//使用queue进行迭代


// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};



class Solution {

public:
    vector<vector<int>> levelOrder(Node* root) {

        vector<vector<int>> res;
        res.clear();
        if(root == NULL)
            return res;

        queue<Node*> q;
        q.push(root);

        while(!q.empty())
        {
            int cout =  q.size();
            vector<int> cur_level;

            while(cout --){

                Node *curr = q.front();
                q.pop();

                cur_level.push_back(curr->val);

                for(Node* it:curr->children)
                    q.push(it);
            }

            res.push_back(cur_level);
        }

        return res;
    }

};

