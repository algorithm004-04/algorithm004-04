#
# @lc app=leetcode.cn id=212 lang=python3
#
# [212] 单词搜索 II
#

# @lc code=start

# 四连通遍历
dx = [-1,1,0,0]
dy = [0,0,-1,1]
END_OF_WORD = "#"

class Solution:
    def findWords1(self, board: List[List[str]], words: List[str]) -> List[str]:
        if not board or not board[0]:
            return []
        if not words:
            return []
        self.result = set()

        # 构建trie
        root = {}
        for word in words:
            node = root
            for char in word:
                node = node.setdefault(char, {})
            node[END_OF_WORD] = END_OF_WORD

        self.m, self.n = len(board), len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] in root:
                    self._dfs(board, i, j, "", root)
        return list(self.result)

    def _dfs(self, board, i, j, cur_word, cur_dict):
        # 终止条件
        cur_word += board[i][j]
        cur_dict = cur_dict[board[i][j]]
        if END_OF_WORD in cur_dict:
            self.result.add(cur_word)
        # 处理当前层
        # board[i][j] = @ 防止字母被重复使用
        tmp, board[i][j] = board[i][j], '@'
        # board[i][j]附近的4个点进行扩散
        for k in range(4):
            x, y = i + dx[k], j + dy[k]
            # drill down下一层
            # x, y必须在棋盘内，且board[x][y]不能已经使用，
            # 且board[x][y]是在当前层级里面的
            if 0 <= x < self.m and 0 <= y < self.n \
                and board[x][y] != '@' and board[x][y] in cur_dict:
                self._dfs(board, x, y, cur_word, cur_dict)
        board[i][j] = tmp # 恢复当前的board[i][j]原值

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = {}  # 构造字典树
        for word in words:
            node = trie
            for char in word:
                node = node.setdefault(char, {})
            node['#'] = True

        def search(i, j, node, pre, visited):  # (i,j)当前坐标，node当前trie树结点，pre前面的字符串，visited已访问坐标
            if '#' in node:  # 已有字典树结束
                res.add(pre)  # 添加答案
            for (di, dj) in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                _i, _j = i+di, j+dj
                if -1 < _i < h and -1 < _j < w and board[_i][_j] in node and (_i, _j) not in visited:  # 可继续搜索
                    search(_i, _j, node[board[_i][_j]], pre+board[_i][_j], visited | {(_i, _j)})  # dfs搜索

        res, h, w = set(), len(board), len(board[0])
        for i in range(h):
            for j in range(w):
                if board[i][j] in trie:  # 可继续搜索
                    search(i, j, trie[board[i][j]], board[i][j], {(i, j)})  # dfs搜索
        return list(res)
    
# @lc code=end

