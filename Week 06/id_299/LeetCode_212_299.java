package algorithm;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
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
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 *
 * 提示:
 *
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_212_299 {
    private static int rows;
    private static int cols;
    private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) {
        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'},
        };
        String[] words = {"oath","pea","eat","rain"};
        List<String> list = findWords(board,words);
        for(String l : list){
            System.out.println("result---->"+l);
        }
    }

    public static List<String> findWords(char[][] board, String[] words) {
        // 构建字典树
        WordTrie wordTrie = new WordTrie();
        TrieNode root = wordTrie.root;
        for(String s: words){
            wordTrie.insert(s);
        }

        // 使用set防止重复
        Set<String>  result = new HashSet<>();
        rows = board.length;
        cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        // 遍历整个二维数组
        for(int i =0;i< rows;i++){
            for(int j =0;j < cols; j++){
                find(board,visited, i, j,result,root);
            }
        }
        return new LinkedList<String>(result);
    }

    private static void find(char[][] board ,boolean[][] visited, int i ,int j,Set<String> result,TrieNode cur){
        // 判断是否已经访问过,以及超出边界
        if(i >= rows || i< 0 || j >= cols || j <0 || visited[i][j]){
            return;
        }
        cur = cur.child[board[i][j] - 'a'];
        visited[i][j]= true;

        if(cur==null){
            // 如果不匹配回退
            visited[i][j]= false;
            return;
        }
        if(cur.isLeaf){
            result.add(cur.val);
        }
        for (int k=0;k<4;k++){
            find(board,visited,i + directions[k][0],j + directions[k][1],result,cur);
        }
        visited[i][j] = false;
    }
}

class WordTrie{
    public TrieNode root = new TrieNode();
    public void insert(String s){
        TrieNode cur = root;
        for(char c: s.toCharArray()){
            if(cur.child[c - 'a'] ==null){
                cur.child[c - 'a'] = new TrieNode();
                cur = cur.child[c - 'a'];
            } else {
                cur = cur.child[c - 'a'];
            }
        }
        cur.isLeaf = true;
        cur.val = s;
    }
}

//字典树结点
class TrieNode{
    public String val;
    public TrieNode[] child = new TrieNode[26];
    public boolean isLeaf = false;

    TrieNode(){}
}
