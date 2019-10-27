/*
 * @lc app=leetcode.cn id=1 lang=cpp
 *
 * [1] 两数之和
 */

// @lc code=start
/*  1. 暴力求解
** 时间复杂度： O(N^2)
*/
class Solution {
public:
  vector<int> twoSum(vector<int>& nums, int target) {
    vector<int> res;
    for (int i = 0; i < nums.size(); ++i) {
      for (int j = i+1; j < nums.size(); ++j) {
        if (nums[i] + nums[j] == target) {
          res.push_back(i);
          res.push_back(j);
          return res;
        }
      }
    }
    return res;
  }
};

/*  2. 使用map
** 时间复杂度： O(N)
*/
class Solution {
public:
  vector<int> twoSum(vector<int>& nums, int target) {
    vector<int> res;
    map<int, int> nums_map;
    for (int i = 0; i < nums.size(); ++i) {
      int searched = target - nums[i];
      if (nums_map.find(searched) != nums_map.end()) {
        res.push_back(i);
        res.push_back(nums_map[searched]);
        return res;
      }
      nums_map[nums[i]] = i;
    }

    return res;
  }
};
// @lc code=end

