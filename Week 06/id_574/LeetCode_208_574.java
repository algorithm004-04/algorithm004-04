package SuanFa.Week06;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 *
 * 说明:
 *
 *
 * 	你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 	保证所有输入均为非空字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_208_574 {
    public static void main(String[] args) {

    }
}
class Trie {
    public MyTrieNode root;
    public Trie() {
        root = new MyTrieNode();
    }
    public void insert(String word){
        MyTrieNode node = root;
        for (int i = 0; i<word.length();i++) {
            char currentChar = word.charAt(i);
            if (!node.containKey(currentChar)) {
                node.put(currentChar,new MyTrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    public MyTrieNode searchPrefix(String word) {
        MyTrieNode node = root;
        for (int i=0;i<word.length();i++) {
            char currentChar = word.charAt(i);
            if (root.containKey(currentChar)) {
                node = node.get(currentChar);
            }
            else {
                return null;
            }
        }
        return node;
    }

    public boolean search(String word) {
        MyTrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startWith(String prefix) {
        MyTrieNode node = root;
        return node != null;
    }
}
class MyTrieNode {
    private MyTrieNode[] links;
    private final int R = 26;
    private boolean isEnd;
    public MyTrieNode() {
        links = new MyTrieNode[R];
    }
    public boolean containKey(char ch) {
        return links[ch - 'a'] != null;
    }
    public MyTrieNode get(char ch) {
        return links[ch - 'a'];
    }
    public void put(char ch, MyTrieNode node) {
        links[ch - 'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}

