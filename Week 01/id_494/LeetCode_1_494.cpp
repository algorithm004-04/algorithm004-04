/*
 * @lc app=leetcode id=1 lang=cpp
 *
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (44.61%)
 * Likes:    12104
 * Dislikes: 421
 * Total Accepted:    2.2M
 * Total Submissions: 4.9M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * Example:
 *
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 *
 */

#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

// @lc code=start
class Solution {
 public:
  // 1. 双层循环暴力求解
  // 2. hash表方式
  vector<int> twoSum(vector<int>& nums, int target) {
    unordered_map<int, int> hash_table;
    for (int i = 0; i < nums.size(); i++) {
      hash_table.emplace(nums[i], i);  // !数组中的value作为hashmap的key，数组中的下标作为hashmap的值
    }

    for (int i = 0; i < nums.size(); i++) {
      auto iter = hash_table.find(target - nums[i]);
      if (iter != hash_table.end() && iter->second != i) { // !不能是自身相加
        return {i, iter->second};
      }
    }

    return {};
  }

  vector<int> twoSum1(vector<int>& nums, int target) {
    for (int i = 0; i < nums.size() - 1; i++) {
      for (int j = i + 1; j < nums.size(); j++) {
        if (nums[i] + nums[j] == target) {
          return {i, j};
        }
      }
    }
    return {};
  }
};
// @lc code=end
