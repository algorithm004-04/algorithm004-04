package com.kkkkkk.demovvorld.leetcode33;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[0] || nums[0] > nums[mid] || target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
