/*
 * @lc app=leetcode id=127 lang=cpp
 *
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (26.11%)
 * Likes:    1967
 * Dislikes: 931
 * Total Accepted:    317.2K
 * Total Submissions: 1.2M
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 *
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 *
 *
 * Note:
 *
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 *
 * Example 1:
 *
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 *
 *
 * Example 2:
 *
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 *
 *
 *
 *
 *
 */

#include <queue>
#include <string>
#include <unordered_set>
#include <vector>

using namespace std;

// @lc code=start
class Solution {
 public:
  int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
    unordered_set<string> dict(wordList.begin(), wordList.end());
    queue<string> q;
    q.push(beginWord);
    int level = 1;
    while (!q.empty()) {
      int n = q.size();
      while(n--) {
        auto word = q.front();
        q.pop();
        if (word == endWord) {
          return level;
        }
        for(int i = 0; i < word.size(); i++) {
          auto newWord = word;
          for(int j = 0; j < 26; j++) {
            newWord[i] = 'a' + j;
            if(dict.count(newWord)) {
              q.push(newWord);
              dict.erase(newWord);
            }
          }
        }
      }
      level++;
    }
    return 0;
  }
  /**
   * 搜索算法，对字典中的单词，按层级逐个遍历
   */
  int ladderLength1(string beginWord, string endWord,
                    vector<string>& wordList) {
    unordered_set<string> words_dict(wordList.begin(), wordList.end());
    queue<string> todo;
    todo.push(beginWord);
    int ladder = 1;
    while (!todo.empty()) {
      // 当前层需要搜索n次
      int n = todo.size();
      // 在当前层匹配单词
      for (int i = 0; i < n; i++) {
        // 取出当前层需要匹配的单词
        auto word = todo.front();
        todo.pop();
        if (word == endWord) {
          // 如果遇到结束单词直接返回最短的路径数
          return ladder;
        }
        // 从字典中擦除当前层使用的单词，防止形成环
        words_dict.erase(word);
        // 搜索是单词字典中是否存在可以接上的单词，
        for (int j = 0; j < word.size(); j++) {
          // 替换单词中的每个字符，并从字典中查找是否存在
          char c = word[j];
          for (int k = 0; k < 26; k++) {
            word[j] = 'a' + k;
            if (words_dict.find(word) != words_dict.end()) {
              // 单词存在，说明该单词可以接上，入队列，作为下次需要匹配的层级中的单词
              todo.push(word);
            }
          }
          // 还原单词
          word[j] = c;
        }
      }
      // 层级数++
      ladder++;
    }
    return 0;
  }
};
// @lc code=end

int main() {
  vector<string> words{"hot", "dot", "dog", "lot", "log", "cog"};
  string wordBeg = "hit";
  string wordEnd = "cog";
  Solution().ladderLength(wordBeg, wordEnd, words);
  return 0;
}
