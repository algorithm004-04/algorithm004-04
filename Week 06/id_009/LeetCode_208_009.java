/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class LeetCode_208_009 {
    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.insert("abc");
        trie.insert("cfg");
        System.out.println(trie.startsWith("ab"));
        System.out.println(trie.search("abcf"));
    }

}

class TrieNode {
    private TrieNode[] nodes;

    private final int R = 26;

    boolean isEnd;

    public TrieNode() {
        this.nodes = new TrieNode[R];
    }

    public boolean containsKey(char c) {
        return this.nodes[c -'a'] != null;
    }
    public TrieNode get(char c) {
        return nodes[c -'a'];
    }
    public void put(char c, TrieNode node) {
        nodes[c -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(!node.containsKey(c)){
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                node = null;
                break;
            }
        }
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                node = null;
                break;
            }
        }
        return node != null;
    }
}