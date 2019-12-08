class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
      tree = {}
      for word in words:
        t = tree
        for w in word:
          t = t.setdefault(w, {})
        t["end"] = 1
      res = []
      row = len(board)
      col = len(board[0])

      def dfs(i, j, trie, s):
        c = board[i][j]
        if c not in trie:
            return
        trie = trie[c]
        if 'end' in trie and trie['end'] == 1:
          res.append(s+c)
          trie['end'] = 0
        board[i][j] = '#'
        for x, y in [[-1, 0], [1, 0], [0, 1], [0, -1]]:
          temp_i = x+i
          temp_j = y+j
          if 0 <= temp_i < row and 0 <= temp_j < col and board[temp_i][temp_j] != '#':
            dfs(temp_i, temp_j, trie, s+c)

        board[i][j] = c

      for i in range(row):
        for j in range(col):
          dfs(i, j, tree, '')
      return res
