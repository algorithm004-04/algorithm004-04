class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        self.m, self.n = len(board[0]), len(board)
        self.res = set()
        self.directions = ((1, 0), (0, 1), (-1, 0), (0, -1))

        word_trie = Trie()
        for word in words:
            word_trie.insert(word)

        for i in range(self.n):
            for j in range(self.m):
                print(i, j)
                self.travel_board(board, word_trie, board[i][j], i, j)
        
        return self.res

    def travel_board(self, board, word_trie, word, i, j):
        if word_trie.search(word):
            self.res.add(word)
        for x,y in ((1, 0), (0, 1), (-1, 0), (0, -1)):
            if 0 <= i+x < self.n and 0 <= j+y < self.m:
                if board[i+x][j+y] == '@':
                    continue

                next_word = word + board[i+x][j+y]
                if word_trie.startsWith(next_word):
                    temp, board[i][j] = board[i][j], "@"
                    self.travel_board(board, word_trie, next_word, i+x, j+y)
                    board[i][j] = temp



class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        current = self.root
        for letter in word:
            current = current.children[letter]
        current.is_word = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        current = self.root
        for letter in word:
            current = current.children.get(letter)
            if current is None:
                return False
        return current.is_word
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        current = self.root
        for letter in prefix:
            current = current.children.get(letter)
            if current is None:
                return False
        return True

class TrieNode:
    def __init__(self):
        """
        Initialize the trie node
        """
        self.children = collections.defaultdict(TrieNode)
        self.is_word = False

