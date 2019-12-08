from collections import defaultdict


class Solution:
    def findLadders(self, beginWord, endWord, wordList):
        if endWord not in wordList or not wordList:
            return []
        result = []
        visited = set([beginWord])
        catch_collection = defaultdict(list)
        L = len(beginWord)
        for i in range(L):
            for val in wordList:
                catch_collection[val[:i]+'*'+val[i+1:]].append(val)
        queue = [(beginWord, 0, [beginWord])]
        level = 0
        catch_visited = {
            beginWord: 0
        }
        while queue:
            curr_word, curr_level, parent_list = queue.pop(0)
            if level != 0 and curr_level > level:
                return result
            for i in range(L):
                temp = curr_word[:i]+'*'+curr_word[i+1:]
                catch_collection_words = catch_collection[temp]
                for val in catch_collection_words:
                    if val not in visited or catch_visited[val] == curr_level:
                        if val == endWord:
                            temp_arr = parent_list.copy()
                            temp_arr.append(val)
                            temp_l = len(temp_arr)
                            if level == temp_l or level == 0:
                                level = temp_l
                                result.append(temp_arr)
                        else:
                            temp_arr = parent_list.copy()
                            temp_arr.append(val)
                            queue.append((val, curr_level+1, temp_arr))
                            visited.add(val)
                            catch_visited[val] = curr_level

        return result
