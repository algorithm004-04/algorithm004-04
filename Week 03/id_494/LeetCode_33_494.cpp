/*
 * @lc app=leetcode id=33 lang=cpp
 *
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (33.30%)
 * Likes:    3165
 * Dislikes: 371
 * Total Accepted:    508K
 * Total Submissions: 1.5M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 */

#include <vector>

using namespace std;

// @lc code=start
class Solution {
 public:
  // 1. 将数组恢复为正常排序 O(NlgN)
  // 2. 找到旋转点，再分治的二分查找，O(N)
  // 3. 直接在这样的数组上搜索，改造二分的终止条件O(lgN)
  // note : 旋转后，旋转中心的右半段 < 左半段，有nums[left] >= nums[right]
  int search(vector<int>& nums, int target) {
    int lo = 0, hi = nums.size() - 1;
    while (lo < hi) {
      int mid = (lo + hi) / 2;
      if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
        lo = mid + 1;
      else
        hi = mid;
    }
    return lo == hi && nums[lo] == target ? lo : -1;
  }

  // 作者：LukeLee
  // 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-jian-solution-by-lukelee/
  // 来源：力扣（LeetCode）
  // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
};
// @lc code=end

int main() { return -1; }
