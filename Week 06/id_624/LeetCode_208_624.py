#
# @lc app=leetcode.cn id=208 lang=python3
#
# [208] 实现 Trie (前缀树)
#
# https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
#
# algorithms
# Medium (61.67%)
# Likes:    147
# Dislikes: 0
# Total Accepted:    16.5K
# Total Submissions: 26.4K
# Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
#
# 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
# 
# 示例:
# 
# Trie trie = new Trie();
# 
# trie.insert("apple");
# trie.search("apple");   // 返回 true
# trie.search("app");     // 返回 false
# trie.startsWith("app"); // 返回 true
# trie.insert("app");   
# trie.search("app");     // 返回 true
# 
# 说明:
# 
# 
# 你可以假设所有的输入都是由小写字母 a-z 构成的。
# 保证所有输入均为非空字符串。
# 
# 
#

# @lc code=start
class Trie:

    def __init__(self):
        self.root = {}
        self.end_of_word = "#"

    def insert(self, word: str) -> None:
        n = self.root
        for c in word:
            n = n.setdefault(c, {})
        n[self.end_of_word] = self.end_of_word

    def search(self, word: str) -> bool:
        n = self.root
        for c in word:
            if c not in n: return False
            n = n[c]
        return self.end_of_word in n
        

    def startsWith(self, prefix: str) -> bool:
        n = self.root
        for c in prefix:
            if c not in n: return False
            n = n[c]
        return True     

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
# @lc code=end

