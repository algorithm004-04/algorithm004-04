class TrieNode
{
public:
  TrieNode *child[26] = {nullptr};
  bool is_str = false;
  string word;
};

class Trie
{
public:
  Trie()
  {
    root_ = new TrieNode();
  }
  ~Trie()
  {
    clear(root_);
    root_ = nullptr;
  }

  void insert(string word)
  {
    TrieNode *node = root_;
    for (int i = 0; i < word.size(); i++)
    {
      if (!node->child[word[i] - 'a'])
      {
        node->child[word[i] - 'a'] = new TrieNode();
      }
      node = node->child[word[i] - 'a'];
    }
    node->is_str = true;
    node->word = word;
  }

  void search(vector<vector<char>> &board, vector<string> &res)
  {
    for (int i = 0; i < board.size(); i++)
    {
      for (int j = 0; j < board[0].size(); j++)
      {
        DFSHelper(root_, i, j, board, res);
      }
    }
  }

  // bool startsWith(string word,bool& is_str){
  //     TrieNode* node = root_;
  //     for(int i = 0; i < word.size(); i++){
  //         if(!node->child[word[i] - 'a']){
  //             return false;
  //         }
  //         node = node->child[word[i] - 'a'];
  //     }
  //     is_str = node->is_str;
  //     return true;
  // }

private:
  TrieNode *root_ = nullptr;
  int dx[4] = {1, -1, 0, 0};
  int dy[4] = {0, 0, 1, -1};
  void clear(TrieNode *node)
  {
    if (node)
    {
      for (int i = 0; i < 26; i++)
      {
        if (node->child[i])
        {
          clear(node->child[i]);
          node->child[i] = nullptr;
        }
      }
    }
  }

  void DFSHelper(TrieNode *node, int row, int col, vector<vector<char>> &board, vector<string> &res)
  {
    if (node->is_str)
    {
      res.push_back(node->word);
      node->is_str = false;
    }
    if (row < 0 || row >= board.size() || col < 0 || col >= board[0].size() || board[row][col] == '@')
    {
      return;
    }
    char temp_ch = board[row][col];
    if (!node->child[temp_ch - 'a'])
    {
      return;
    }
    node = node->child[temp_ch - 'a'];
    board[row][col] = '@';
    for (int i = 0; i < 4; i++)
    {
      DFSHelper(node, row + dy[i], col + dx[i], board, res);
    }
    board[row][col] = temp_ch;
  }
};

class Solution
{
public:
  vector<string> findWords(vector<vector<char>> &board, vector<string> &words)
  {
    vector<string> res;
    if (words.size() == 0 || words[0].size() == 0)
      return res;

    for (int i = 0; i < words.size(); i++)
    {
      trie_.insert(words[i]);
    }

    // for(int i = 0; i < board.size(); i++){
    //     for(int j = 0; j < board[0].size(); j++){
    //         dfs(i, j, "", board);
    //     }
    // }
    trie_.search(board, res);
    return res;
  }

private:
  Trie trie_;

  // void dfs(int row, int col, string current_word, vector<vector<char>>& board){
  //     if(row < 0 || row >= board.size() || col < 0 || col >= board[0].size() || board[row][col] == '@') return;
  //     current_word += board[row][col];

  //     bool is_str = false;
  //     // 先看看前缀
  //     if(!trie_.startsWith(current_word,is_str)){
  //         return;
  //     }

  //     if(is_str){
  //         res_set_.insert(current_word);
  //     }
  //     char temp_ch = board[row][col];
  //     board[row][col] = '@';
  //     for(int i = 0; i< 4; i++){
  //         dfs(row + dy[i], col + dx[i], current_word, board);
  //     }

  //     board[row][col] = temp_ch;
  // }
};