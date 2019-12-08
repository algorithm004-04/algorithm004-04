/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */
import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
       Arrays.sort(nums);
       return nums[nums.length / 2]; 
    }
}

