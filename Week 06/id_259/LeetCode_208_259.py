'''
208. 实现 Trie (前缀树)
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

示例:
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");
trie.search("app");     // 返回 true
说明:
你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
'''
'''
from collections import defaultdict

class TrieNode:
    def __init__(self):
        self.nodes = defaultdict(TrieNode)
        self.isEnd = False

class Trie:
    def __init__(self):
        'Initialize your data structure here.'
        self.root = TrieNode()

    def insert(self, word):
        'Inserts a word into the trie.'
        curr = self.root
        for ch in word:
            if ch not in curr.nodes:
                curr.nodes[ch] = TrieNode()
            curr = curr.nodes[ch]
        curr.isEnd = True

    def search(self, word):
        ' Returns if the word is in the trie.'
        curr = self.root
        for ch in word:
            if ch not in curr.nodes:
                return False
            curr = curr.nodes[ch]
        return curr.isEnd

    def startsWith(self, prefix):
        'Returns if there is any word in the trie that starts with the given prefix.'
        curr = self.root
        for ch in prefix:
            if ch not in curr.nodes:
                return False
            curr = curr.nodes[ch]
        return True
    # def show(self):
    #     curr = self.root
    #     for ch in curr.nodes:
    #         print('{}, curr.isEnd={}'.format(ch,curr.isEnd))
    #         curr = curr.nodes[ch]
'''
import collections
class TrieNode:
    def __init__(self):
        # self.nodes = {}
        self.nodes = collections.defaultdict(TrieNode)
        self.isEnd = False

class Trie:
    def __init__(self):
        'Initialize your data structure here.'
        self.root = TrieNode()

    def insert(self, word):
        'Inserts a word into the trie.'
        curr = self.root
        for ch in word:
            if ch not in curr.nodes:
                curr.nodes[ch] = TrieNode()
            curr = curr.nodes[ch]
        curr.isEnd = True

    def search(self, word):
        ' Returns if the word is in the trie.'
        curr = self.root
        for ch in word:
            if ch not in curr.nodes:
                return False
            curr = curr.nodes[ch]
        return curr.isEnd

    def startsWith(self, prefix):
        'Returns if there is any word in the trie that starts with the given prefix.'
        curr = self.root
        for ch in prefix:
            if ch not in curr.nodes:
                return False
            curr = curr.nodes[ch]
        return True
    def show(self):
        curr = self.root
        for ch in curr.nodes:
            print('{}, curr.isEnd={}'.format(ch,curr.isEnd))
            curr = curr.nodes[ch]



#["Trie","insert","search","search","startsWith","insert","search"]
# [[],["apple"],["apple"],["app"],["app"],["app"],["app"]]
test = Trie()
test.insert('apple')
test.show()
# print(test.search('apple'))
# print(test.search('app'))
# print(test.startWith('app'))
# print(test.insert('app'))
test.insert('bed')
test.show()
# print(test.search('app'))
# print(test.startWith('app'))

