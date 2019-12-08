class TrieNode
{
public:
  TrieNode *child[26] = {nullptr};
  bool is_str = false;
};

class Trie
{
public:
  /** Initialize your data structure here. */
  Trie()
  {
    root_ = new TrieNode();
  }

  ~Trie()
  {
    clear(root_);
    delete root_;
    root_ = nullptr;
  }

  /** Inserts a word into the trie. */
  void insert(string word)
  {
    TrieNode *node = root_;
    for (int i = 0; i < word.size(); i++)
    {
      if (node->child[word[i] - 'a'] == nullptr)
      {
        node->child[word[i] - 'a'] = new TrieNode();
      }
      node = node->child[word[i] - 'a'];
    }
    node->is_str = true;
  }

  /** Returns if the word is in the trie. */
  bool search(string word)
  {
    TrieNode *node = root_;
    for (int i = 0; i < word.size(); i++)
    {
      if (node->child[word[i] - 'a'] == nullptr)
      {
        return false;
      }
      else
      {
        node = node->child[word[i] - 'a'];
      }
    }
    if (node->is_str)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  bool startsWith(string prefix)
  {
    TrieNode *node = root_;
    for (int i = 0; i < prefix.size(); i++)
    {
      if (node->child[prefix[i] - 'a'] == nullptr)
      {
        return false;
      }
      else
      {
        node = node->child[prefix[i] - 'a'];
      }
    }
    return true;
  }

private:
  TrieNode *root_ = nullptr;

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
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */