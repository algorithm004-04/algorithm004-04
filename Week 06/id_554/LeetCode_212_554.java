package com.kkkkkk.demovvorld.leetcode212;

import com.kkkkkk.demovvorld.leetcode208.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (trie.startsWith(String.valueOf(board[i][j]))) {
                    dfs(board, i, j, "", trie);
                }
            }
        }
        return new ArrayList<>(result);
    }

    Set<String> result = new HashSet<>();
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int m = 0;
    int n = 0;


    private void dfs(char[][] board, int i, int j, String curStr, Trie curTrie) {
        curStr += board[i][j];
        Trie.TrieNode curTrieNode = curTrie.getRoot().get(board[i][j]);
        if (curTrieNode.getEnd()) {
            result.add(curStr);
        }

        char temp = board[i][j];
        board[i][j] = '@'; // @代表遍历过
        for (int k = 0; i < 4; ++i) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (0 <= x && x <= n
                    && 0 <= y && y <= m
                    && board[x][y] != '@'
                    && curTrieNode.containsKey(board[x][y])) {
                dfs(board, x, y, curStr, new Trie(curTrieNode));
            }
        }
    }
}
