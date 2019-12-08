/*
 * @lc app=leetcode id=189 lang=cpp
 *
 * [189] Rotate Array
 *
 * https://leetcode.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (31.80%)
 * Likes:    1718
 * Dislikes: 670
 * Total Accepted:    357.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 *
 * Example 1:
 *
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 *
 * Example 2:
 *
 *
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 *
 * Note:
 *
 *
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 *
 */

#include <iostream>
#include <vector>
#include "tools.hpp"

using namespace std;

// @lc code=start
class Solution {
 public:
  void rotate(vector<int>& nums, int k) {
    k = k % nums.size();
    int count = 0, start = nums.size() - 1;
    while (count < nums.size()) {
      int temp = nums[start];
      int current = start;
      int next = (current - k) >= 0 ? (current - k) : (current - k + nums.size());
      while(next != start) {
          nums[current] = nums[next];
          current = next;
          next = (current - k) >= 0 ? (current - k) : (current - k + nums.size());
          count++;
      }
      nums[current] = temp;
      count++;
      start--;
    }
  }

  void rotate4(vector<int>& nums, int k) {
    k = k % nums.size();
    int count = 0, start = nums.size() - 1;
    while (count < nums.size()) {
      int temp = nums[start];
      int current = start;
      do {
        int next = (current - k) >= 0 ? (current - k) : (current - k + nums.size());
        if (next == start) {
          nums[current] = temp;
        } else {
          nums[current] = nums[next];
        }
        current = next;
        count++;
      } while (current != start);
      start--;
    }
  }

  void rotate3(vector<int>& nums, int k) {
    k = k % nums.size();
    int count = 0;
    for (int start = 0; count < nums.size(); start++) {
      int current = start;
      int prev = nums[start];
      do {
        int next = (current + k) % nums.size();
        int temp = nums[next];
        nums[next] = prev;
        prev = temp;
        current = next;
        count++;
      } while (start != current);
    }
  }

  void rotate2(vector<int>& nums, int k) {
    vector<int> temp;
    temp.reserve(nums.size());
    for (int i = 0; i < nums.size(); i++) {
      temp[(i + k) % nums.size()] = nums[i];
    }
    for (int i = 0; i < nums.size(); i++) {
      nums[i] = temp[i];
    }
  }

  void rotate1(vector<int>& nums, int k) {
    for (int i = 0; i < k; i++) {
      int temp = nums.back();
      for (int i = nums.size() - 1; i > 0; i--) {
        nums[i] = nums[i - 1];
      }
      nums[0] = temp;
    }
  }
};
// @lc code=end

int main() {
  vector<int> nums2{1, 2, 3, 4, 5, 6, 7};
  Solution().rotate(nums2, 3);
  print_result(nums2, 0, 0, nums2.size());
  return 0;
}
