package week_06.lesson13;

public class ImplementPrefixTrie {

    private TrieNode root;

    public ImplementPrefixTrie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (!node.containsKey(cur)) {
                node.put(cur, new TrieNode());
            }
            node = node.get(cur);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = getTrieNode(word);
        return null != node && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = getTrieNode(prefix);
        return null != node;
    }

    private TrieNode getTrieNode(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char cur = prefix.charAt(i);
            if (node.containsKey(cur)) {
                node = node.get(cur);
            } else {
                return null;
            }
        }
        return node;
    }
}


class TrieNode {

    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

}
