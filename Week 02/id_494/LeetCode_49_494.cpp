/*
 * @lc app=leetcode id=49 lang=cpp
 *
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (50.04%)
 * Likes:    2139
 * Dislikes: 134
 * Total Accepted:    417.8K
 * Total Submissions: 834K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 *
 * Note:
 *
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 *
 */
#include <stdio.h>
#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

// @lc code=start
class Solution {
 public:
  // 基数排序+hashmap O(N*K) K字符串最大长度
  // 暴力法 O(N^2)
  vector<vector<string>> groupAnagrams(vector<string>& strs) {
    if (strs.empty()) {
      return {};
    }
    vector<vector<string>> result;
    unordered_map<string, vector<string>> hash_map;
    // unordered_map<string, vector<string>&> hash_map; // !尝试对result内的vector<string>做引用，存在引用失效问题
    for (auto& str : strs) {
      auto sorted = sortString(str);
      auto found = hash_map.find(sorted);
      if (found != hash_map.end()) {
        found->second.emplace_back(str);
      } else {
        hash_map.emplace(sorted, vector<string>{str});
      }
    }
    result.resize(hash_map.size());
    auto map_iter = hash_map.begin();
    auto ret_iter = result.begin();
    for (; map_iter != hash_map.end(); map_iter++, ret_iter++) {
      ret_iter->swap(map_iter->second);
    }
    return result;
  }

  vector<vector<string>> groupAnagrams2(vector<string>& strs) {
    if (strs.empty()) {
      return {};
    }
    vector<vector<string>> result;
    result.emplace_back(vector<string>{strs[0]});
    for (auto i = 1; i < strs.size(); i++) {
      auto t = strs[i];
      bool placed = false;
      for (auto& vec : result) {
        if (isAnagrams(vec.back(), t)) {
          vec.emplace_back(t);
          placed = true;
        }
      }
      if (!placed) {
        result.emplace_back(vector<string>{strs[i]});
      }
    }
    return result;
  }

 private:
  string sortString(string& s) {
    string sorted;
    vector<int> counter(26);
    for (auto& c : s) {
      counter[c - 'a']++;
    }
    for (auto i = 0; i < 26; i++) {
      if (counter[i]) {
        sorted += string(counter[i], i + 'a');
      }
    }
    return sorted;
  }

  bool isAnagrams(string& s, string& t) {
    if (s.size() != t.size()) {
      return false;
    }
    vector<int> counter(26);
    for (int i = 0; i < s.size(); i++) {
      counter[s[i] - 'a']++;
      counter[t[i] - 'a']--;
    }
    for (auto& count : counter) {
      if (count != 0) {
        return false;
      }
    }
    return true;
  }
};
// @lc code=end

int main() {
  vector<string> input{"eat", "tea", "tan", "ate", "nat", "bat"};
  auto result = Solution().groupAnagrams(input);
  std::cout << "[\n";
  for (auto& vec : result) {
    std::cout << "[";
    for (auto& str : vec) {
      std::cout << str << " ";
    }
    std::cout << "]\n";
  }
  std::cout << "]\n";
  return 0;
}
