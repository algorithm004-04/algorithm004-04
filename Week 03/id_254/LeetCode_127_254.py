from collections import defaultdict


# class Solution:
#     def ladderLength(self, beginWord, endWord, wordList):
#         if endWord not in wordList or not beginWord or not endWord or not wordList:
#             return 0
#         word_collection = defaultdict(list)
#         queue = [(beginWord, 1)]
#         L = len(beginWord)
#         for val in wordList:
#             for i in range(L):
#                 word_collection[val[:i]+'*'+val[i+1:]].append(val)

#         visited = set([beginWord])

#         while queue:
#             word, level = queue.pop(0)
#             for i in range(L):
#                 temp = word[:i]+'*'+word[i+1:]
#                 temp_arr = word_collection[temp]
#                 if temp_arr:
#                     for word_c in temp_arr:
#                         if word_c != endWord:
#                             if word_c not in visited:
#                                 visited.add(word_c)
#                                 queue.append((word_c, level+1))
#                         else:
#                             return level+1
#                 word_collection[temp] = []

#         return 0


class Solution:

    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList or not wordList:
            return 0
        L = len(beginWord)
        catch_dict = defaultdict(list)
        for word in wordList:
            for i in range(L):
                catch_dict[word[:i]+'*'+word[i+1:]].append(word)

        def helpfn(stack, currTypeVisited, reverseTypeVisited):
            word, level = stack.pop(0)
            for i in range(L):
                temp = word[:i]+'*'+word[i+1:]
                wordList = catch_dict[temp]
                for item in wordList:
                    if item in reverseTypeVisited:
                        return level+reverseTypeVisited[item]
                    elif item not in currTypeVisited:
                        currTypeVisited[item] = level+1
                        stack.append((item, level+1))
                catch_dict[temp] = []
            return None

        begin_visited = {beginWord: 1}
        end_visited = {endWord: 1}
        beginStack = [(beginWord, 1)]
        endStack = [(endWord, 1)]
        ans = None
        while beginStack and endStack:
            ans = helpfn(beginStack, begin_visited, end_visited)
            if ans:
                return ans
            ans = helpfn(endStack, end_visited, begin_visited)
            if ans:
                return ans
        return 0
