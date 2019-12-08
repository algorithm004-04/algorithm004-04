/*
 * @lc app=leetcode.cn id=33 lang=cpp
 *
 * [33] 搜索旋转排序数组
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (36.07%)
 * Likes:    396
 * Dislikes: 0
 * Total Accepted:    51.5K
 * Total Submissions: 142.6K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 
 */

// @lc code=start
/*
** 二分查找
** [l...r]
** 1. target == nums[mid]
** 2. nums[l] <= target < nums[mid] 
** 3. nums[mid] < target <= nums[r]
*/
class Solution {
public:
  int search(vector<int>& nums, int target) {
    int l = 0, r = nums.size() - 1;

    while (l <= r) {
      int mid = l + ((r - l) >> 1);
      if (target == nums[mid]) {
        return mid;
      }

      if (nums[l] <= nums[mid]) {
        // 左半侧升序
        if (target >= nums[l] && target < nums[mid]) {
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      } else {
        if (target > nums[mid] && target <= nums[r]) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
    }
    
    return -1;
  }
};

/*
** 二分查找
** 1. 　nums[0] <= target <= nums[mid]
** 2.  nums[mid] < nums[0]   ====> 
                target <= nums[i] < nums[0] or nums[i] < nums[0] <= target
*/
class Solution {
public:
  int search(vector<int>& nums, int target) {
    int l = 0, r = nums.size() - 1;
    while (l < r) {
      int mid = l + ((r - l) >> 1);
      
      if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
        l = mid + 1;
      } else if (target > nums[mid] && target < nums[0]) {
        l = mid + 1;
      } else {
        r = mid;
      }
    }

    return l == r && nums[l] == target ? l : -1;
  }
};

/*
** 二分查找
** XOR
** nums[0] <= target, target <= nums[mid] and nums[mid] < nums[0]
** 这三个条件不能可能全true或者全false， 可能有两个true或者一个true
** 对每个i大致循环：
    nums[0] <= target <= nums[i]
               target <= nums[i] < nums[0]
                         nums[i] < nums[0] <= target
*/
class Solution {
public:
  int search(vector<int>& nums, int target) {
    int l = 0, r = nums.size() - 1;
    while (l < r) {
        int mid = l + ((r - l) >> 1);
        if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
            l = mid + 1;
        else
            r = mid;
    }
    return l == r && nums[l] == target ? l : -1;
  }
}

/*
Let's say nums looks like this: 
[12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

Because it's not fully sorted, we can't do normal binary search. 
But here comes the trick:

If target is let's say 14, then we adjust nums to this, where "inf" means infinity:
[12, 13, 14, 15, 16, 17, 18, 19, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf]

If target is let's say 7, then we adjust nums to this:
[-inf, -inf, -inf, -inf, -inf, -inf, -inf, -inf, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

And then we can simply do ordinary binary search.


If nums[mid] and target are "on the same side" of nums[0], we just take nums[mid]. 
Otherwise we use -infinity or +infinity as needed.
*/

class Solution {
public:
  int search(vector<int>& nums, int target) {
    int l = 0, r = nums.size();
    while (l < r) {
      int mid = l + ((r - l) >> 1);
      double num = (nums[mid] < nums[0]) == (target < nums[0])
                  ? nums[mid]
                  : target < nums[0] ? -INFINITY : INFINITY;
                  
      if (num < target)
        l = mid + 1;
      else if (num > target)
        r = mid;
      else
        return mid;
    }
    return -1;
  }
};

// @lc code=end

