package com.codertoy.week06;

import java.util.*;

public class Leecode_212_339 {
    Set<String> result = new HashSet<>();
    int[] dictX = new int[]{-1, 1, 0, 0};
    int[] dicty = new int[]{0, 0, -1, 1};

    public List<String> findWords(char[][] board, String[] words) {
        Trie wordNode = new Trie();
        for (String word : words) {
            wordNode.insert(word);
        }

        int x = board.length;
        int y = board[0].length;
        boolean[][] visited = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                find(board,visited,i,j,x,y,wordNode.getRoot());
            }
        }
        return new LinkedList<>(result);
    }

    private void find(char[][] board, boolean[][] visited, int i, int j, int x, int y, TrieNode curr) {
        if (i < 0 || i >= x || j < 0 || j >= y || visited[i][j]) return;
        curr = curr.get(board[i][j]);
        if (curr == null) {
            return;
        }
        visited[i][j] = true;
        if (curr.isEnd()) {
            result.add(curr.getValue());
        }

        for (int k = 0; k < 4; k++) {
            find(board, visited, i + dictX[k], j + dicty[k], x, y, curr);
        }
        visited[i][j] = false;
    }
}
