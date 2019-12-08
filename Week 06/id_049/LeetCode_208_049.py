class Trie:
    def __init__(self):
        self.root = {}
        self.end_of_word = "#"

    def insert(self, word: str) -> None:
        node = self.root
        for char in word:
            node = node.setdefault(char, {})
        node[self.end_of_word] = self.end_of_word

    def search(self, word: str) -> bool:
        node = self.root
        for char in word:
            if char not in node:
                return False
            node = node[char]
        return self.end_of_word in node

    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for char in prefix:
            if char not in node:
                return False
            node = node[char]
        return True

    def insertTest(self, word: str) -> None:
        node = self.root
        for char in word:
            if char not in node:
                node[char] = {}
                node = node[char]
        node[self.end_of_word] = self.end_of_word
