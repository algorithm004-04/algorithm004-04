#
# @lc app=leetcode.cn id=127 lang=python3
#
# [127] 单词接龙
#
# https://leetcode-cn.com/problems/word-ladder/description/
#
# algorithms
# Medium (37.12%)
# Likes:    149
# Dislikes: 0
# Total Accepted:    12.7K
# Total Submissions: 34.1K
# Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
#
# 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
# 的最短转换序列的长度。转换需遵循如下规则：
# 
# 
# 每次转换只能改变一个字母。
# 转换过程中的中间单词必须是字典中的单词。
# 
# 
# 说明:
# 
# 
# 如果不存在这样的转换序列，返回 0。
# 所有单词具有相同的长度。
# 所有单词只由小写字母组成。
# 字典中不存在重复的单词。
# 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
# 
# 
# 示例 1:
# 
# 输入:
# beginWord = "hit",
# endWord = "cog",
# wordList = ["hot","dot","dog","lot","log","cog"]
# 
# 输出: 5
# 
# 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
# ⁠    返回它的长度 5。
# 
# 
# 示例 2:
# 
# 输入:
# beginWord = "hit"
# endWord = "cog"
# wordList = ["hot","dot","dog","lot","log"]
# 
# 输出: 0
# 
# 解释: endWord "cog" 不在字典中，所以无法进行转换。
# 
#

# @lc code=start

from collections import defaultdict

class Solution:
    # bfs
    # def ladderLength(self, beginWord: str, endWord: str, wordList: [str]) -> int:
    #     if not beginWord or not endWord or endWord not in wordList: return 0
    #     all_combo_word, wordLengthRange = defaultdict(list), range(len(beginWord))

    #     for word in wordList:
    #         for i in wordLengthRange: 
    #             all_combo_word[word[:i] + "*" + word[i+1:]].append(word)

    #     queue, visited = [(beginWord, 1)], set([beginWord]) 

    #     while queue:
    #         cur, level = queue.pop(0)
    #         for i in wordLengthRange:
    #             intermediateWord = cur[:i] + "*" + cur[i+1:]
    #             for word in all_combo_word[intermediateWord]:
    #                 if word == endWord: return level+1
    #                 if word not in visited:
    #                     visited.add(word)
    #                     queue.append((word, level+1))
    #     return 0

    def ladderLength(self, beginWord: str, endWord: str, wordList: [str]) -> int:
        if not beginWord or not endWord or not wordList or endWord not in wordList: return 0
        all_combo_dict, wordLenRange = defaultdict(list), range(len(beginWord))

        for word in wordList:
            for i in wordLenRange:
                all_combo_dict[word[:i] + "*" + word[i+1:]].append(word)

        queue, visited = [(beginWord, 1)], set([beginWord])

        while queue:
            cur, level = queue.pop(0)
            for i in wordLenRange:
                intermediateWord = cur[:i] + "*" + cur[i+1:]
                for word in intermediateWord[intermediateWord]:
                    if word == endWord: return level + 1
                    if word not in visited:
                        visited.add(word)
                        queue.append((word, level+1))

        return 0




    # 双向bfs

        
# @lc code=end

