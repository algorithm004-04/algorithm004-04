'''
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。

'''


class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):

        wordList = list(set(wordList))
        connections = {}
        for word1 in wordList+[beginWord]:
            arr = []
            for word2 in wordList:
                diff = 0
                for i in range(len(word2)):
                    if word1[i] != word2[i]:
                        diff += 1
                if diff == 1:
                    arr.append(word2)
            connections[word1] = arr

        q = []
        q.append((beginWord, 1))
        seen = set()
        while len(q) > 0:
            word, level = q.pop(0)
            seen.add(word)
            if word == endWord:
                return level
            children = connections[word]
            for child in children:
                if child not in seen:
                    q.append((child, level+1))
        return 0