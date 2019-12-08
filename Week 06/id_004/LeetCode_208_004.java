import java.util.HashMap;
import java.util.Map;

class Trie {

    /**
     * Initialize your data structure here.
     */

    private HashMap root = new HashMap();
    private Character endOfTheWord = '#';

    public Trie() {
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

        Map node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new HashMap<>());
            }
            node = (Map) node.get(word.charAt(i));
        }

        node.put(endOfTheWord, endOfTheWord);

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {

        Map node = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = (Map) node.get(word.charAt(i));
        }
        return node.containsKey(endOfTheWord);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Map node = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!node.containsKey(prefix.charAt(i))) {
                return false;
            }
            node = (Map) node.get(prefix.charAt(i));
        }

        return true;

    }
}