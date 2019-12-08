class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        def dfs(i, j, t, s):
            ch = board[i][j]
            if ch not in t:
                return
            t = t[ch]
            if "end" in t and t["end"] == 1:
                res.append(s+ch)
                t["end"] = 0
            board[i][j] = "#"
            if i + 1 < m and board[i+1][j] != "#":
                dfs(i+1, j, t, s+ch)
            if i - 1 >= 0 and board[i-1][j] != "#":
                dfs(i-1, j, t, s+ch)
            if j + 1 < n and board[i][j+1] != "#":
                dfs(i, j+1, t, s+ch)
            if j - 1 >= 0 and board[i][j-1] != "#":
                dfs(i, j-1, t, s+ch)
            board[i][j] = ch 
        trie = {}
        for word in words:
            t = trie
            for ch in word:
                if ch not in t:
                    t[ch] = {}
                t = t[ch]
            t["end"] = 1
        
        m = len(board)
        n = len(board[0])
        res = []
        for i in range(m):
            for j in range(n):
                dfs(i, j, trie, "")
        return res
