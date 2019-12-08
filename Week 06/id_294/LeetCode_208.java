package week06;

import java.util.HashMap;
import java.util.Map;

/** Trie树的实现 每个节点定义固定长度数组，目前是字母26个，比较浪费空间 */
class Trie {
  class Node {
    String value;
    Node[] children;
    boolean isWord;

    public Node() {
      this.children = new Node[26];
      this.isWord = false;
    }

    public Node Get(int index) {
      return children[index];
    }

    public void Set(int index, Node child) {
      children[index] = child;
    }
  }

  /** 利用Map动态分配空间 */
  class DynamicNode {
    Map<Integer, DynamicNode> children;
    boolean isWord;

    public DynamicNode() {
      children = new HashMap<Integer, DynamicNode>();
    }

    public DynamicNode Get(int index) {
      return children.getOrDefault(index, null);
    }

    public void Set(int index, DynamicNode child) {
      children.put(index, child);
    }
  }

  DynamicNode root;

  public Trie() {
    this.root = new DynamicNode();
  }

  public void insert(String word) {
    DynamicNode root = this.root;
    int len = word.length();
    for (int i = 0; i < len; i++) {
      int index = word.charAt(i) - 'a';
      if (root.Get(index) == null) {
        DynamicNode child = new DynamicNode();
        root.Set(index, child);
        root = child;
      } else {
        root = root.Get(index);
      }
    }
    root.isWord = true;
  }

  public DynamicNode findLast(String word) {
    DynamicNode root = this.root;
    int len = word.length();
    for (int i = 0; i < len && root != null; i++) {
      int index = word.charAt(i) - 'a';
      root = root.Get(index);
    }
    return root;
  }

  public boolean search(String word) {
    DynamicNode root = this.findLast(word);
    return root == null ? false : root.isWord;
  }

  public boolean startsWith(String prefix) {
    DynamicNode root = this.findLast(prefix);
    return root != null;
  }
}

public class LeetCode_208 {
  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    boolean r = trie.search("app");
    System.out.println(r);
    r = trie.startsWith("app");
    System.out.println(r);
    trie.insert("app");
    r = trie.search("app");
    System.out.println(r);
  }
}
