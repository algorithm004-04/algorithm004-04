# https://leetcode-cn.com/problems/word-ladder/
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        begin = {beginWord}
        end = {endWord}
        beginWordLen = len(beginWord)
        wordList = set(wordList)
        length = 1
        while begin:
            length += 1
            nextWordSet = set()
            for word in begin:
                for i in range(beginWordLen):
                    for j in 'abcdefghijklmnopqrstuvwxyz':
                        if j != word[i]:
                            nextWord = word[:i] + j + word[i + 1:]
                            if nextWord in end:
                                return length
                            if nextWord in wordList:
                                nextWordSet.add(nextWord)
                                wordList.remove(nextWord)
            begin = nextWordSet
            if len(end) < len(begin):
                end, begin = begin, end
        return 0