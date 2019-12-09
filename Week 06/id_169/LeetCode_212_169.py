from typing import List
from collections import defaultdict


class TrieNode:

    def __init__(self):
        self.nodes = defaultdict(TrieNode)
        self.isword = False


class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        current = self.root
        for char in word:
            current = current.nodes[char]
        current.isword = True


class Solution:

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = Trie()
        for word in words:
            trie.insert(word)

        result, root = set(), trie.root

        for y in range(len(board)):
            for x in range(len(board[y])):
                if board[y][x] in root.nodes:
                    self.dfs(x, y, root, board, '', result)

        return list(result)

    def dfs(self, x, y, trie_node, board, word, result):
        if trie_node.isword:
            result.add(word)
            trie_node.isword = False
        if y < 0 or y >= len(board):
            return
        if x < 0 or x >= len(board[0]):
            return
        if board[y][x] not in trie_node.nodes:
            return
        trie_node = trie_node.nodes[board[y][x]]
        current, board[y][x] = board[y][x], '#'
        self.dfs(x, y - 1, trie_node, board, word + current, result)
        self.dfs(x + 1, y, trie_node, board, word + current, result)
        self.dfs(x, y + 1, trie_node, board, word + current, result)
        self.dfs(x - 1, y, trie_node, board, word + current, result)
        board[y][x] = current

