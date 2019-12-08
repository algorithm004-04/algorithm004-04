"""
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
"""

from collections import deque
import string

class Solution:
    def ladderLength(self, begin_word: str, end_word: str, word_list: List[str]) -> int:
        wset = set(word_list)
        queue = deque([(begin_word, 1)])
        
        while queue:
            word, steps = queue.popleft()
            
            if word == end_word:
                return steps
            
            for i in range(len(word)):
                for ch in string.ascii_lowercase:
                    trans = word[:i] + ch + word[i+1:]
                    if trans in wset:
                        wset.remove(trans)
                        queue.append((trans, steps+1))
            
        return 0
    
