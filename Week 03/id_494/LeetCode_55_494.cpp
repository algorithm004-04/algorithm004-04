/*
 * @lc app=leetcode id=55 lang=cpp
 *
 * [55] Jump Game
 *
 * https://leetcode.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (32.74%)
 * Likes:    2554
 * Dislikes: 243
 * Total Accepted:    322.4K
 * Total Submissions: 983.8K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 *
 * Each element in the array represents your maximum jump length at that
 * position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.
 *
 *
 * Example 2:
 *
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its
 * maximum
 * jump length is 0, which makes it impossible to reach the last index.
 *
 *
 */
#include <vector>
#include <algorithm>

using namespace std;

// @lc code=start
class Solution {
 public:
  bool canJump(vector<int>& nums) {
    int k = 0; // 能调到的最远index
    for (int i = 0; i < nums.size(); i++) {
       // 如果当前索引大于能跳到的最远index，说明调不到最后
       if(i > k) return false;
       // 这里不断更新能调到的最远index
       k = std::max(k, i + nums[i]);
    }
    return true;
  }
};
// @lc code=end
