#
# @lc app=leetcode.cn id=126 lang=python3
#
# [126] 单词接龙 II
#
# https://leetcode-cn.com/problems/word-ladder-ii/description/
#
# algorithms
# Hard (28.32%)
# Likes:    83
# Dislikes: 0
# Total Accepted:    4K
# Total Submissions: 13.3K
# Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
#
# 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord
# 的最短转换序列。转换需遵循如下规则：
# 
# 
# 每次转换只能改变一个字母。
# 转换过程中的中间单词必须是字典中的单词。
# 
# 
# 说明:
# 
# 
# 如果不存在这样的转换序列，返回一个空列表。
# 所有单词具有相同的长度。
# 所有单词只由小写字母组成。
# 字典中不存在重复的单词。
# 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
# 
# 
# 示例 1:
# 
# 输入:
# beginWord = "hit",
# endWord = "cog",
# wordList = ["hot","dot","dog","lot","log","cog"]
# 
# 输出:
# [
# ⁠ ["hit","hot","dot","dog","cog"],
# ["hit","hot","lot","log","cog"]
# ]
# 
# 
# 示例 2:
# 
# 输入:
# beginWord = "hit"
# endWord = "cog"
# wordList = ["hot","dot","dog","lot","log"]
# 
# 输出: []
# 
# 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
# 
#

# @lc code=start
class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        if endWord not in wordList:
            return []
        wordListSet = set(wordList)
        from collections import defaultdict
        stepMap = defaultdict(list)
        wordMap = defaultdict(list)
        wordListSet.add(beginWord)
        n = len(beginWord)
        for word in wordListSet:
            for j in range(n):
                k = word[:j] + '_' + word[j+1:]
                wordMap[word].append(k)
                stepMap[k].append(word)

        result = []
        begin_queue = {beginWord: [[beginWord]]}
        wordListSet.remove(beginWord)
        end_queue = {endWord:[[endWord]]}
        wordListSet.remove(endWord)

        def BFS(queue1, queue2, result, forward):
            tmp = defaultdict(list)
            for (word, paths) in queue1.items():
                for k in wordMap[word]:
                    for w in stepMap[k]: 
                        if w in queue2:
                            if forward:
                                result.extend(queue1_path + queue2_path[::-1] for queue1_path in paths for queue2_path in queue2[w])
                            else:
                                result.extend(queue2_path + queue1_path[::-1] for queue1_path in paths for queue2_path in queue2[w])
                        if w in wordListSet:
                            tmp[w].extend([path+[w] for path in paths])
            
            wordListSet.difference_update(tmp.keys())
            queue1 = tmp
            return queue1, result
        
        while begin_queue and end_queue:
            if len(begin_queue) <= len(end_queue):
                begin_queue, result = BFS(begin_queue, end_queue, result, True)
            else:
                end_queue, result = BFS(end_queue, begin_queue, result, False)
            if result:
                return result
        
        return result
                
# @lc code=end

