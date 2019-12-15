# https://leetcode-cn.com/problems/implement-trie-prefix-tree/submissions/
# 208. 实现Trie
class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.trie = {}

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        root = self.trie
        for c in word:
            root = root.setdefault(c, {})
        root['#'] = '#'

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        root = self.trie
        for c in word:
            if c in root:
                root = root[c]
            else:
                return False
        return '#' in root

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        root = self.trie
        for c in prefix:
            if c in root:
                root = root[c]
            else:
                return False
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)