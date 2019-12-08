//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
// You may assume that the array is non-empty and the majority element always exist in the array.
//
// Example 1:
//
//
//Input: [3,2,3]
//Output: 3
//
// Example 2:
//
//
//Input: [2,2,1,1,1,2,2]
//Output: 2
//
// Related Topics Array Divide and Conquer Bit Manipulation


import java.util.HashMap;
import java.util.Map;


/**
 * @Author: wangchuande
 * @Date: 2019/10/20 19:53
 */
public class LeetCode_169_314 {
    public int majorityElement(int[] nums) {
        if (nums.length == 1 || nums.length == 2) {
            return nums[0];
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int value = nums[i];
            if (map.containsKey(value)) {
                count = map.get(value) + 1;
                if (count > (nums.length / 2)) {
                    return value;
                }
            }
            map.put(value, count);
        }

        return 0;
    }
}

