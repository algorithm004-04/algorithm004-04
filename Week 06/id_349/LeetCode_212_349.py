# o(m*n*4^k) (m: len(board) , n: len(board[0]), k: words中单词平均长度)
class Solution:
    def findWords(self, board, words): 
        trie = {} # 构造字典树
        for word in words:
            node = trie
            for char in word:
                node = node.setdefault(char, {})
            node['#'] = True

        def search(i, j, node, pre, visited): # (i, j)当前坐标, node当前trie树节点, pre前面的字符串, visited访问过的坐标
            if '#' in node: # 已有字典树结束
                res.add(pre) # 添加答案
            for (di, dj) in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                _i, _j = i + di, j + dj
                if -1 < _i < h and -1 < _j < w and board[_i][_j] in node and (_i, _j) not in visited: 
                    search(_i, _j, node[board[_i][_j]], pre+board[_i][_j], visited | {(_i, _j)}) # dfs 搜索

        res, h, w = set(), len(board), len(board[0])
        for i in range(h):
            for j in range(w):
                if board[i][j] in trie: # 可继续搜索
                    search(i, j, trie[board[i][j]], board[i][j], {(i, j)})
        return list(res)
            

