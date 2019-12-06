# https://leetcode-cn.com/problems/word-search-ii/
class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = {}
        for word in words:
            node = trie
            for char in word:
                node = node.setdefault(char, {})
            node['#'] = True
        # print(trie)
        # {'o': {'a': {'t': {'h': {'#': True}}}}, 'p': {'e': {'a': {'#': True}}}, 'e': {'a': {'t': {'#': True}}}, 'r': {'a': {'i': {'n': {'#': True}}}}}
        res, m, n = set(), len(board), len(board[0])
        # i，j坐标；node当前trie树节点，pre前面的字符串；visited已访问的坐标

        # 否所字典树DFS
        def search(i, j, node, pre, visited):
            print(node)
            print(pre)
            print(visited)
            print('------------')
            if '#' in node:  # 递归终止条件，已有字典树结束
                res.add(pre)
            for x, y in ((-1, 0), (1, 0), (0, -1), (0, 1)):  # 还是4个方向的dfs
                new_i, new_j = i+x, j+y
                # 可继续搜索
                if 0 <= new_i < m and 0 <= new_j < n and board[new_i][new_j] in node and (new_i, new_j) not in visited:
                    search(new_i, new_j, node[board[new_i][new_j]], pre +
                           board[new_i][new_j], visited | {(new_i, new_j)})

        for i in range(m):
            for j in range(n):
                if board[i][j] in trie:
                    print(board[i][j])
                    search(i, j, trie[board[i][j]], board[i][j], {(i, j)})
        return list(res)
