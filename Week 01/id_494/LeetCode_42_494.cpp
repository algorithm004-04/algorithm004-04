/*
 * @lc app=leetcode id=42 lang=cpp
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (45.23%)
 * Likes:    4653
 * Dislikes: 82
 * Total Accepted:    364.1K
 * Total Submissions: 804.8K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 *
 * Example:
 *
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 */

#include <iostream>
#include <vector>

using namespace std;

// @lc code=start
class Solution {
 public:
  /**
   * 双指针法
   */
  int trap(vector<int>& height) {
    if (height.size() < 3) {
      return 0;
    }
    int max_trapped_water = 0;
    int right_height = height[height.size() - 1];
    int left_height = height[0];
    for (int i = 1, j = height.size() - 2; i <= j;) { //! 由于left/right_height落后i、j，故i，j需要相遇
      if (left_height < right_height) {
        if (left_height > height[i]) {
          max_trapped_water += left_height - height[i];
        } else {
          left_height = height[i];
        }
        i++;
      } else {
        if (right_height > height[j]) {
          max_trapped_water += right_height - height[j];
        } else {
          right_height = height[j];
        }
        j--;
      }
    }
    return max_trapped_water;
  }
};
// @lc code=end

int main() {
  vector<int> nums{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
  std::cout << Solution().trap(nums) << "\n";
  return 0;
}
