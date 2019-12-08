/*
 * @lc app=leetcode id=45 lang=cpp
 *
 * [45] Jump Game II
 *
 * https://leetcode.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (29.07%)
 * Likes:    1573
 * Dislikes: 87
 * Total Accepted:    202.6K
 * Total Submissions: 695.6K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 *
 * Each element in the array represents your maximum jump length at that
 * position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * ⁠   Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Note:
 *
 * You can assume that you can always reach the last index.
 *
 */

#include <vector>

using namespace std;

// @lc code=start
class Solution {
 public:
  // 贪心算法 - 每次都找到能跳的最远的位置，
  int jump(vector<int>& nums) {
    // https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
    int boundary = 0;
    int maxPosition = 0;
    int steps = 0;
    for (int i = 0; i < nums.size() - 1; i++) {
      maxPosition = std::max(maxPosition, i + nums[i]);
      if (i == boundary) {
        boundary = maxPosition;
        steps++;
        if(boundary >= nums.size() - 1) {
          break;
        }
      }
    }
    return steps;
  }
};
// @lc code=end

int main() { return 0; }
