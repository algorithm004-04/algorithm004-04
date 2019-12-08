package week_06.lesson13;

import java.util.*;

public class WordSearchTwo {

    private int[] x = new int[]{-1, 1, 0, 0};

    private int[] y = new int[]{0, 0, -1, 1};

    public List<String> findWords(char[][] board, String[] words) {
        if (null == words) {
            return null;
        }
        WordTrie myTrie = new WordTrie();
        //构建Trie树
        for (String s : words) {
            myTrie.insert(s);
        }

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        Set<String> result = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                search(board, visited, i, j, m, n, myTrie.root, result);
            }
        }
        return new ArrayList<>(result);

    }

    private void search(char[][] board, boolean[][] visited, int i,
                        int j, int m, int n, TrieNodeSearch root, Set<String> result) {
        if ((i < 0 || i >= m) || (j < 0 || j >= n) || visited[i][j]) {
            return;
        }
        if (null == root.get(board[i][j])) {
            if (root.isEnd() && null != root.getValue()) {
                result.add(root.getValue());
            }
            return;
        }
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            search(board, visited, i + x[k], j + y[k], m, n, root.get(board[i][j]), result);
        }
        visited[i][j] = false;

    }

    public static void main(String[] args) {
        WordSearchTwo myTrie = new WordSearchTwo();
        /*char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};*/
        char[][] board = new char[][]{{'a'}};
        String[] words = new String[]{"a"};
        System.out.println(myTrie.findWords(board, words));
    }

}

class WordTrie {
     TrieNodeSearch root = new TrieNodeSearch();
     void insert(String word) {
        TrieNodeSearch node = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (!node.containsKey(cur)) {
                node.put(cur, new TrieNodeSearch());
            }
            node = node.get(cur);
        }
        node.setValue(word);
        node.setEnd();
    }
}

class TrieNodeSearch {

    private TrieNodeSearch[] links;

    private final int R = 26;

    private boolean isEnd;

    private String value;

    TrieNodeSearch() {
        links = new TrieNodeSearch[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNodeSearch get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNodeSearch node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
