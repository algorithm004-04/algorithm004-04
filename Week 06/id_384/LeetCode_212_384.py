class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        if not board or not board[0] or not words: return []
        self.res = set()
        root = {}
        end_of_word = '#'
        for w in words:
            node = root
            for char in w:
                node = node.setdefault(char, {})
            node[end_of_word] = end_of_word

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] in root:
                    self.xun(board, i, j, '', root, {(i, j)})
        return self.res

    def xun(self, board, i, j, pre, node, visited):
        pre += board[i][j]
        node = node[board[i][j]]
        if '#' in node:
            self.res.add(pre)
        for (di, dj) in ((-1, 0), (1, 0), (0, 1), (0, -1)):
            _i, _j = i + di, j + dj
            if -1 < _i < len(board) and -1 < _j < len(board[0]) and board[_i][_j] in node and ((_i, _j)) not in visited:
                self.xun(board, _i, _j, pre, node, visited | {(_i, _j)})
