package weak_06;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LeetCode_212_234 {

  public List<String> findWords(char[][] board, String[] words) {

    // init trie
    Trie trie = new Trie();
    for (int i = 0; i < words.length; i++) {
      trie.insert(words[i]);
    }
    Set<String> result = new HashSet<>();
    int rows = board.length;
    int columns = board[0].length;
    // 遍历board
    boolean[][] visited = new boolean[rows][columns];
    // 遍历整个二维数组
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, visited, i, j, rows, columns, result, trie.root);
      }
    }

    return new LinkedList<String>(result);
  }
    private void dfs(char [] [] board, boolean [][]visited, int i, int j, int m, int n, Set<String> result, TrieNode cur){
        //边界以及是否已经访问判断
        if(i<0||i>=m||j<0||j>=n||visited[i][j])
            return;
        char tmpBoardij = board[i][j];
        cur=cur.get(tmpBoardij);
        visited[i][j]=true;
        if(cur==null)
        {
            //如果单词不匹配，回退
            visited[i][j]=false;
            return;
        }
        //找到单词加入
        if(cur.isEnd())
        {
            result.add(cur.getNodeValue());
        }
        dfs(board,visited,i+1,j,m,n,result,cur);
        dfs(board,visited,i,j+1,m,n,result,cur);
        dfs(board,visited,i,j-1,m,n,result,cur);
        dfs(board,visited,i-1,j,m,n,result,cur);
        //最后要回退，因为下一个起点可能会用到上一个起点的字符
        visited[i][j]=false;
    }

    public class Trie {

        public TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
            root.setNodeValue("/");
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    // 没有则创建
                    TrieNode _node = new TrieNode();

                    node.put(ch, _node);
                }
                // 取出下一个node
                node = node.get(ch);
            }
            node.setNodeValue(word);
            // 设置终点
            node.setEnd();
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.containsKey(ch)) {
                    node = node.get(ch);
                } else {
                    return null;
                }
            }
            return node;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            // 搜索前缀不需要判断是否end
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }


    }

    public class TrieNode {

        // R links to node children
        private String nodeValue;

        public String getNodeValue() {
            return String.valueOf(nodeValue) ;
        }

        public void setNodeValue(String nodeValue) {
            this.nodeValue = nodeValue;
        }

        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;


        public TrieNode() {
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


}

