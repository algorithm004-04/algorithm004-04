package weak_06;

public class Trie {

  public TrieNode root;
  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode();
    root.setNodeValue("/");
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (!node.containsKey(ch)) {
        // 没有则创建
        TrieNode _node = new TrieNode();

        node.put(ch, _node);
      }
      // 取出下一个node
      node = node.get(ch);
    }
    node.setNodeValue(word);
    // 设置终点
    node.setEnd();
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode node = searchPrefix(word);
    return node != null && node.isEnd();
  }

  TrieNode searchPrefix(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (node.containsKey(ch)) {
        node = node.get(ch);
      } else {
        return null;
      }
    }
    return node;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    // 搜索前缀不需要判断是否end
    TrieNode node = searchPrefix(prefix);
    return node != null;
  }


}
