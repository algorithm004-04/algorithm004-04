package com.kkkkkk.demovvorld.leetcode208;

public class Trie {

    public class TrieNode {
        private static final int SIZE = 26;

        /**
         * null: not link
         */
        private TrieNode[] links;

        /**
         * leaf node
         */
        private Boolean end;

        public TrieNode() {
            links = new TrieNode[SIZE];
        }

        public Boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public void add(char ch) {
            links[ch - 'a'] = new TrieNode();
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void setEnd() {
            end = true;
        }

        public Boolean getEnd() {
            return end;
        }
    }

    private TrieNode root;

    public TrieNode getRoot() {
        return root;
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    public Trie(TrieNode root) {
        this.root = root;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            char t = word.charAt(i);
            if (!root.containsKey(t)) {
                node.add(t);
            }
            node = node.get(t);
        }
        node.setEnd();
    }

    /**
     * find prefix node
     *
     * @param prefix
     * @return
     */
    public TrieNode prefixSearch(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); ++i) {
            char t = prefix.charAt(i);
            if (node.containsKey(t)) {
                node = node.get(t);
            } else {
                node = null;
                break;
            }
        }
        return node;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = prefixSearch(word);
        return node != null && node.getEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = prefixSearch(prefix);
        return node != null;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("app");
        boolean b1 = obj.search("app");
        boolean b2 = obj.startsWith("app");
        System.out.println("b1: " + b1);
        System.out.println("b2: " + b2);
    }
}