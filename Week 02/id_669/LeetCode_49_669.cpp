/*
 * @lc app=leetcode.cn id=49 lang=cpp
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (58.64%)
 * Likes:    200
 * Dislikes: 0
 * Total Accepted:    33.6K
 * Total Submissions: 57K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * 说明：
 * 
 * 
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 
 * 
 */

// @lc code=start
/*
* 采用26个长度的字符串作为hashmap的key
* 使用map来记录具有相同的key的串
*/
class Solution {
public:
  vector<vector<string>> groupAnagrams(vector<string>& strs) {
    vector<vector<string>> res;
    if (strs.size() == 0) 
      return res;
    map<string, vector<string>> map;
    for (int i = 0; i < strs.size(); ++i) {
      char tmp[26] = {0};
      for (int j = 0; j < strs[i].length(); ++j) {
        tmp[strs[i][j] - 'a'] = 1;
      }
      printf("%s\n", tmp);
      map[string(tmp, 26)].push_back(strs[i]);
    }

    for (auto iter = map.begin(); iter != map.end(); ++iter) {
      res.push_back(iter->second);
    }

    return res;
  }
};


/*
* 将每个字符串进行排序，记录当前插入的index
* 将排序后相同的串插入相同的index
*/
class Solution {
public:
  vector<vector<string>> groupAnagrams(vector<string>& strs) {
    vector<vector<string>> res;
    if (strs.size() == 0) 
      return res;
    map<string, int> map;

    for (int i = 0; i < strs.size(); ++i) {
      string tmp = strs[i];
      sort(tmp.begin(),tmp.end());
      
      if(map.find(tmp)==map.end()) {
        map.insert({tmp,(int)res.size()});
        res.push_back(vector<string>{strs[i]});
      } else {
        res[map[tmp]].push_back(strs[i]);
      }
    }
    
    return res;
  }
};
// @lc code=end

