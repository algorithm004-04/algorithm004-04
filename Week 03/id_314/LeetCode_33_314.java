//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
// You are given a target value to search. If found in the array return its index, otherwise return -1.
//
// You may assume no duplicate exists in the array.
//
// Your algorithm's runtime complexity must be in the order of O(log n).
//
// Example 1:
//
//
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
//
//
// Example 2:
//
//
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Related Topics Array Binary Search



import java.util.HashMap;
import java.util.Map;


public class LeetCode_33_314 {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }


    private int helper(int[] nums, int target, int left, int right) {
        if (nums == null || nums.length == 0 || left < 0 || right >= nums.length || left > right) {
            return -1;
        }


        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }

        }

        return -1;

    }
}

