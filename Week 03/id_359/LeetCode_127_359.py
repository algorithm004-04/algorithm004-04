# 127.单词接龙
# https://leetcode-cn.com/problems/word-ladder/
# one direction BSF, visited set is not need
# test case => wordList不含endWord，wordList仅含endWord（相似、不相似），wordList含2个及以上词（连通、不连通）
from collections import deque
from collections import defaultdict
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        wordDict, wordSet = defaultdict(set), set(wordList)
        if endWord in wordSet:
            for word in wordList:
                for j in range(len(word)):
                    newWord = word[:j] + "*" + word[j+1:]
                    wordDict[newWord].add(word)
            queue, level = deque([beginWord]), 0
            while queue:
                size, level = len(queue), level+1 # record front level size & visit next level
                for i in range(size): # iterate front level word
                    word = queue.popleft() # pop from left to right
                    for j in range(len(word)): # try to map every letter j
                        newWord = word[:j] + "*" + word[j+1:]
                        if endWord in wordDict[newWord]:
                            return level + 1
                        for nextword in wordDict[newWord]:
                            if nextword in wordSet: 
                                queue.append(nextword) # append to next level
                                wordSet.remove(nextword) # delete after visit 
                        wordDict[newWord].clear() # delete after visit
        return 0