import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/word-search-ii/
 */
public class LeetCode_212_009 {
    public List<String> findWords(char[][] board, String[] words) {
        //构建字典树
        Trie trie = new Trie();
        TrieNode root = trie.root;
        for(String word : words){
            trie.insert(word);
        }
        //使用set防止重复
        Set<String> result = new HashSet<>();
        int h = board.length;
        int w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        String cur = "";
        //遍历整个二维数组
        for(int i = 0; i < h; i++){
            for (int j = 0; j < w; j++){
                find(board, visited, i, j, h, w, result, root, cur);
            }
        }
        return new LinkedList<String>(result);
    }

    private void find(char[][] board, boolean[][] visited, int i, int j, int h, int w, Set<String> result, TrieNode node, String cur) {
        //边界以及是否已经访问判断
        if(i<0 || i>=h || j<0 || j>=w || visited[i][j]){
            return;
        }
        node = node.get(board[i][j]);
        visited[i][j] = true;
        if(node == null) {
            //如果单词不匹配，回退
            visited[i][j] = false;
            return;
        }
        //找到单词加入
        if(node.isEnd){
            result.add(cur + board[i][j]);
            //找到单词后不能回退，因为可能是“ad” “addd”这样的单词得继续回溯
        }
        find(board, visited, i+1, j, h, w, result, node, cur + board[i][j]);
        find(board, visited, i, j+1, h, w, result, node, cur + board[i][j]);
        find(board, visited, i, j-1, h, w, result, node, cur + board[i][j]);
        find(board, visited, i-1, j, h, w, result, node, cur + board[i][j]);
        //最后要回退，因为下一个起点可能会用到上一个起点的字符
        visited[i][j] = false;
    }


}