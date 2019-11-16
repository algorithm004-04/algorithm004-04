from collections import defaultdict


class Solution:
    def ladderLength(self, beginWord, endWord, wordList):
        if endWord not in wordList or not beginWord or not endWord or not wordList:
            return 0
        word_collection = defaultdict(list)
        queue = [(beginWord, 1)]
        L = len(beginWord)
        for val in wordList:
            for i in range(L):
                word_collection[val[:i]+'*'+val[i+1:]].append(val)

        visited = set([beginWord])

        while queue:
            word, level = queue.pop(0)
            for i in range(L):
                temp = word[:i]+'*'+word[i+1:]
                temp_arr = word_collection[temp]
                if temp_arr:
                    for word_c in temp_arr:
                        if word_c != endWord:
                            if word_c not in visited:
                                visited.add(word_c)
                                queue.append((word_c, level+1))
                        else:
                            return level+1
                word_collection[temp] = []

        return 0
