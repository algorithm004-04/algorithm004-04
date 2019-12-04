/*
 * @lc app=leetcode.cn id=17 lang=cpp
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (51.19%)
 * Likes:    479
 * Dislikes: 0
 * Total Accepted:    53K
 * Total Submissions: 103.3K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */

// @lc code=start
/*
* 1. 递归
*/
class Solution {
public:
    vector<string> letterCombinations(string digits) {
        vector<string> res;
        if (digits.length() == 0)
          return res;
        map<char, string> letter_map;
        letter_map['2'] = "abc";
        letter_map['3'] = "def";
        letter_map['4'] = "ghi";
        letter_map['5'] = "jkl";
        letter_map['6'] = "mno";
        letter_map['7'] = "pqrs";
        letter_map['8'] = "tuv";
        letter_map['9'] = "wxyz";
        
        search("", digits, 0, res, letter_map);

        return res;
    }

    void search(string s, string digits, int i, vector<string> &res, map<char, string> map) {
        // terminate
        if (i == digits.length()) {
            res.push_back(s);
            return;
        }

        // process
        const char *p = digits.c_str();
        const char *p_letter = map[*(p+i)].c_str();
        for (int j = 0; j < map[*(p+i)].length(); ++j) {
          search(s + *(p_letter+j), digits, i + 1, res, map);
        }

        // reverse
    }
};

/*
* 2. 迭代
*/
class Solution {
public:
  vector<string> letterCombinations(string digits) {
    vector<string> res;
    if (digits.length() == 0) {
      return res;
    }
    string charmap[10] = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    res.push_back("");
    for (int i = 0; i < digits.size(); ++i) {
      vector<string> tempres;
      string chars = charmap[digits[i] - '0'];
      for (int c = 0; c < chars.size(); ++c) {
        for (int j = 0; j < res.size(); ++j) {
          tempres.push_back(res[j] + chars[c]);
        }
      }
      
      res = tempres;
    }
    return res;
  }
};

// @lc code=end

