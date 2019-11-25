import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode_212_034
 *
 * @Author blackberry
 * @Date 2019/11/24 6:49 PM
 **/
public class LeetCode_212_034 {

    private int m;
    private int n;

    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();

        m = board.length;
        n = board[0].length;

        TrieNode root = buildTrie(words);

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                dfs(board, i, j, root, list);
            }
        }
        return list;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> list) {
        char c = board[i][j];
        if (c == '#' || node.child[c - 'a'] == null) {
            return;
        }
        node = node.child[c - 'a'];
        if (node.word != null) {
            list.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';

        for (int k = 0; k < dx.length; k ++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >=0 && x < m && y >=0 && y < n) {
                dfs(board, x, y, node, list);
            }
        }
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (node.child[i] == null) {
                    node.child[i] = new TrieNode();
                }
                node = node.child[i];
            }
            node.word = word;
        }
        return root;
    }

    class TrieNode {
        private TrieNode[] child = new TrieNode[26];
        private String word;
    }
}
