# -*- coding: utf8 -*-


"""
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: 0

解释: endWord "cog" 不在字典中，所以无法进行转换。
"""
class Solution(object):

    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        possible_words = list(set([w for w in ''.join(wordList)]))
        # possible_words = "abcdefghijklmnopqrstuvwxyz"
        wordList = set(wordList)
        queue = [(beginWord,1)]
        visited = set()
        while queue:
            word,step = queue.pop(0)
            if word == endWord:
                return step
            for i in range(len(word)):
                for p in possible_words:
                    temp_word = word[:i] + p + word[i+1:]
                    if temp_word in wordList and temp_word not in visited:
                        queue.append((temp_word,step+1))
                        visited.add(temp_word)
        return 0

if __name__ == '__main__':
    slt = Solution()

    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log"]
    print(slt.ladderLength(beginWord,endWord,wordList))
