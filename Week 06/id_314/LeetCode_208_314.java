//Implement a trie with insert, search, and startsWith methods.
//
// Example:
//
//
//Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // returns true
//trie.search("app");     // returns false
//trie.startsWith("app"); // returns true
//trie.insert("app");
//trie.search("app");     // returns true
//
//
// Note:
//
//
// You may assume that all inputs are consist of lowercase letters a-z.
// All inputs are guaranteed to be non-empty strings.
//
// Related Topics Design Trie


/**
 * @Author: wangchuande
 * @Date: 2019/10/20 20:37
 */
public class LeetCode_208_314 {

    class TireNode {

        private TireNode[] links;

        private final int R = 26;

        private boolean isEnd;

        public TireNode() {
            links = new TireNode[R];
        }

        public void put(char ch, TireNode node) {
            links[ch - 'a'] = node;
        }

        public TireNode get(char ch) {
            return links[ch - 'a'];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

    }


    class Trie {

        private TireNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TireNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TireNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    node.put(ch, new TireNode());
                }

                node = node.get(ch);
            }
            node.setEnd();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TireNode node = searchPrefix(word);
            return (node != null && node.isEnd()) ? true : false;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TireNode node = searchPrefix(prefix);
            return node != null;
        }


        private TireNode searchPrefix(String prefix) {
            TireNode currentNode = root;

            for (int i = 0; i < prefix.length(); i++) {
                char currentChar = prefix.charAt(i);

                if (!currentNode.containsKey(currentChar)) {
                    return null;
                }
                currentNode = currentNode.get(currentChar);
            }

            return currentNode;
        }
    }

}

