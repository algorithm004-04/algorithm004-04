/*
 * @lc app=leetcode id=242 lang=cpp
 *
 * [242] Valid Anagram
 *
 * https://leetcode.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (53.87%)
 * Likes:    892
 * Dislikes: 118
 * Total Accepted:    412.5K
 * Total Submissions: 765.2K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * Given two strings s and t , write a function to determine if t is an anagram
 * of s.
 *
 * Example 1:
 *
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your
 * solution to such case?
 *
 */

#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;
// "tat" "ata"

// @lc code=start
class Solution {
 public:
  bool isAnagram(string s, string t) {
    if (s.size() != t.size()) {
      return false;
    }
    vector<int> count_char(26);
    for (int i = 0; i < s.size(); i++) {
      count_char[s[i] - 'a']++;
      count_char[t[i] - 'a']--;
    }
    for (auto& count : count_char) {
      if (count != 0) {
        return false;
      }
    }
    return true;
  }

  bool isAnagram2(string s, string t) {
    if (s.size() != t.size()) {
      return false;
    }
    unordered_map<char, int> count_char_s;
    for (auto& e : s) {
      count_char_s[e]++;
    }
    unordered_map<char, int> count_char_t;
    for (auto& e : t) {
      auto found = count_char_s.find(e);
      if (found == count_char_s.end()) {
        return false;
      }
      count_char_t[e]++;
    }
    for (auto& e : t) {
      if (count_char_s[e] != count_char_t[e]) {
        return false;
      }
    }
    return true;
  }
};
// @lc code=end

int main() {
    Solution().isAnagram("ab", "ba");
}