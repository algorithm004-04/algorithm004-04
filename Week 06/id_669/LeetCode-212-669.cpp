/*
 * @lc app=leetcode.cn id=212 lang=cpp
 *
 * [212] 单词搜索 II
 *
 * https://leetcode-cn.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (37.65%)
 * Likes:    73
 * Dislikes: 0
 * Total Accepted:    6.4K
 * Total Submissions: 17K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n' +
  '["oath","pea","eat","rain"]'
 *
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * 
 * 示例:
 * 
 * 输入: 
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ⁠ ['o','a','a','n'],
 * ⁠ ['e','t','a','e'],
 * ⁠ ['i','h','k','r'],
 * ⁠ ['i','f','l','v']
 * ]
 * 
 * 输出: ["eat","oath"]
 * 
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * 
 * 提示:
 * 
 * 
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？
 * 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    struct TrieNode {
        vector<TrieNode*> child;
        string word;
        TrieNode() : word(""), child(vector<TrieNode*>(26, nullptr)) {}
    };
    
    TrieNode* buildTrie(vector<string>& words) {
        TrieNode* root = new TrieNode();
        for (string w : words) {
            TrieNode* curr = root;
            for (char c : w) {
                int i = c - 'a';
                if (curr->child[i] == NULL) curr->child[i] = new TrieNode();
                curr = curr->child[i];
            }
            curr->word = w;
        }
        return root;
    }
    void dfs(vector<vector<char>>& board, int i, int j, TrieNode* curr, vector<string>& out) {
        char c = board[i][j];
        if(c == '#' || curr->child[c - 'a'] == NULL) return;
        curr = curr->child[c - 'a'];
        if (curr->word != "") {
            out.push_back(curr->word);
            curr->word = "";
        }
        board[i][j] = '#';
        if(i > 0) dfs(board, i - 1, j , curr, out); 
        if(j > 0) dfs(board, i, j - 1, curr, out);
        if(i < board.size() - 1) dfs(board, i + 1, j, curr, out); 
        if(j < board[0].size() - 1) dfs(board, i, j + 1, curr, out); 
        board[i][j] = c;
    }

    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        vector<string> out;
        TrieNode* root = buildTrie(words);
        for(int i = 0; i < board.size(); ++i) 
            for(int j = 0; j < board[0].size(); ++j) 
                dfs(board, i, j, root, out);
        return out;
    }
};
// @lc code=end

