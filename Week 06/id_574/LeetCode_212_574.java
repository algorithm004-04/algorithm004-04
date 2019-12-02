package SuanFa.Week06;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 示例:
 *
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 *
 * 输出: ["eat","oath"]
 *
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_212_574 {
    public static void main(String[] args) {

    }

    public List<String> findWords(char[][] board,String[] words) {
        WordTrie trie = new WordTrie();
        TrieNode root = trie.root;
        for (String s: words) {
            trie.insert(s);
        }
        // Set去重
        Set<String> result = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                find(board,visited,i,j,m,n,result,root);
            }
        }
        return new LinkedList<String>(result);

    }
    private void find(char[][] board, boolean[][] visited, int i, int j, int m, int n, Set<String> result, TrieNode curNode) {
        if (i<0||i>m||j<0||j>n||visited[i][j]) return;
        curNode = curNode.child[board[i][j] - 'a'];
        visited[i][j] = true;
        if (curNode == null) {
            visited[i][j] = false;
            return ;
        }
        if (curNode.isLeaf) {
            result.add(curNode.val);
        }
        find(board,visited,i+1,j,m,n,result,curNode);
        find(board,visited,i,j+1,m,n,result,curNode);
        find(board,visited,i,j-1,m,n,result,curNode);
        find(board,visited,i-1,j,m,n,result,curNode);
        visited[i][j] = false;
    }
}
//字典树
class WordTrie{
    public TrieNode root=new TrieNode();
    public void insert(String s){
        TrieNode cur=root;
        for(char c:s.toCharArray()){
            if(cur.child[c-'a']==null){
                cur.child [c-'a'] = new TrieNode();
                cur=cur.child[c-'a'];
            }else
                cur=cur.child [c-'a'];
        }
        cur.isLeaf=true;
        cur.val=s;
    }
}
//字典树结点
class TrieNode{
    public String val;
    public TrieNode[] child=new TrieNode[26];
    public boolean isLeaf=false;

    TrieNode(){

    }
}
