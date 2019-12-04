#! /usr/bin/env python
# coding=utf8

"""
给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

示例:
输入:
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
输出: ["eat","oath"]
说明:
你可以假设所有输入都由小写字母 a-z 组成。

提示:
    你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
    如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search-ii
"""
import collections


# ###################### 字典树部分 #####################
class TrieNode:
    def __init__(self):
        self.children = collections.defaultdict(TrieNode())
        self.is_word = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for w in word:
            node = node.children[w]
        node.is_word = True

    def search(self, word):
        node = self.root
        for w in word:
            node = node.children.get(w)
            if not node:
                return False
        return node.is_word


# dfs
class Solution(object):
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        result = []
        trie = Trie()
        node = trie.root
        for w in words:
            trie.insert(w)
        for i in range(len(board)):
            for j in range(len(board[0])):
                self.dfs(board, node, i, j, "", result)
        return result

    def dfs(self, board, node, i, j, path, res):
        if node.is_word:
            res.append(path)
            node.is_word = False
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]):
            return
        temp = board[i][j]
        node = node.children.get(temp)
        if not node:
            return
        board[i][j] = "#"
        self.dfs(board, node, i+1, j, path + temp, res)
        self.dfs(board, node, i-1, j, path + temp, res)
        self.dfs(board, node, i, j-1, path + temp, res)
        self.dfs(board, node, i, j+1, path + temp, res)
        board[i][j] = temp


if __name__ == '__main__':
    import sys
    sys.setrecursionlimit(10000)
    words = ["oath", "pea", "eat", "rain"]
    board = [
        ['o', 'a', 'a', 'n'],
        ['e', 't', 'a', 'e'],
        ['i', 'h', 'k', 'r'],
        ['i', 'f', 'l', 'v']
    ]
    result = ["eat", "oath"]
    sol = Solution()
    assert sol.findWords(board, words) == result
