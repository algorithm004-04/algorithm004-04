# coding=utf-8

"""
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
    每次转换只能改变一个字母。
    转换过程中的中间单词必须是字典中的单词。
说明:
    如果不存在这样的转换序列，返回 0。
    所有单词具有相同的长度。
    所有单词只由小写字母组成。
    字典中不存在重复的单词。
    你可以假设 beginWord 和 endWord 是非空的，且二者不相同。

示例 1:
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
输出: 0
解释: endWord "cog" 不在字典中，所以无法进行转换。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-ladder
"""
from typing import List
import collections


# 单向BFS
# 双向BFS
class Solution:
    # 效率极低 5%
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        # 预处理所有的单词
        words_dict = self._generate_words_dict(wordList)
        shortest_length = self.bfs(beginWord, endWord, words_dict)
        return shortest_length

    def _generate_words_dict(self, wordList: List[str]) -> dict:
        result = collections.defaultdict(list)
        for word in wordList:
            for i in range(len(word)):
                result[word[:i] + '_' + word[i + 1:]].append(word)
        # print(result)
        return result

    def _get_next_words(self, current_word: str, words_dict: dict) -> set:
        result = set()
        for i in range(len(current_word)):
            for next_word in words_dict[current_word[:i] + '_' + current_word[i + 1:]]:
                if next_word != current_word and next_word not in result:
                    result.add(next_word)
        # print("current: {}, next_words:{}".format(current_word, result))
        return result

    def bfs(self, beginWord: str, endWord: str, words_dict: dict) -> int:
        visited, queue = set(), [(beginWord, 1), ]
        while queue:
            current_word, level = queue.pop(0)
            visited.add(current_word)

            # process current
            if current_word == endWord:
                return level
            next_words = self._get_next_words(current_word, words_dict)
            for next_word in next_words:
                if next_word not in visited:
                    queue.append((next_word, level + 1))
        return 0


if __name__ == '__main__':
    s = Solution()
    params = [
        ["hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"], 5],
        ["hit", "cog", ["hot", "dot", "dog", "lot", "log", ], 0],
    ]
    for param in params:
        assert s.ladderLength(*param[:-1]) == param[-1]


