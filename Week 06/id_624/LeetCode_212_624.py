#
# @lc app=leetcode.cn id=212 lang=python3
#
# [212] 单词搜索 II
#
# https://leetcode-cn.com/problems/word-search-ii/description/
#
# algorithms
# Hard (36.38%)
# Likes:    73
# Dislikes: 0
# Total Accepted:    6.2K
# Total Submissions: 16.7K
# Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n["oath","pea","eat","rain"]'
#
# 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
# 
# 
# 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
# 
# 示例:
# 
# 输入: 
# words = ["oath","pea","eat","rain"] and board =
# [
# ⁠ ['o','a','a','n'],
# ⁠ ['e','t','a','e'],
# ⁠ ['i','h','k','r'],
# ⁠ ['i','f','l','v']
# ]
# 
# 输出: ["eat","oath"]
# 
# 说明:
# 你可以假设所有输入都由小写字母 a-z 组成。
# 
# 提示:
# 
# 
# 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
# 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？
# 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
# 
# 
#

# @lc code=start
from collections import defaultdict

end_of_word = "#"
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

class Solution:
    def findWords(self, board: [[str]], words: [str]) -> [str]:
        if not board or not board[0] or not words: return []

        # 构建字典树
        root, result = {}, set()
        for word in words:
            n = root
            for c in word:
                n = n.setdefault(c, {})
            n[end_of_word] = end_of_word
        
        # (i, j)：当前搜索字母在矩阵中的位置
        # dict：当前搜索字母在字典树中对应值
        # word：已搜索命中的字符串
        # board：字母矩阵
        def search(i: int, j: int, dict:dict, word="", board=board):
            cur_word = word + board[i][j]
            cur_dict = dict[board[i][j]]
            if end_of_word in cur_dict:
                result.add(cur_word)
            temp, board[i][j] = board[i][j], "@"
            for k in range(4):
                x ,y = i + dx[k], j + dy[k]
                if 0 <= x < m and 0 <= y < n and board[x][y] != "@" and board[x][y] in cur_dict:
                    search(x, y, cur_dict, cur_word)
            board[i][j] = temp
            
        # 搜索字典树
        m, n = len(board), len(board[0])
        for i in range(m):
            for j in range(n):
                if board[i][j] in root:
                    search(i, j, root)
        return list(result)
            
# print(Solution().findWords([["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], ["oath","pea","eat","rain"]))
# print(Solution().findWords([["a","a"]], ["a"]))
# @lc code=end

