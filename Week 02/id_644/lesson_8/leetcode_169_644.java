package com.company;
/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class majorityelement {
    public static void main(String[] args) {

    }

    //排序 nlogn
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //暴力法
    public int majorityElement(int[] nums) {
        int mcount = nums.length / 2;
        for (int n : nums) {
            int count = 0;
            for (int n1 : nums) {
                if (n1 == n)
                    count++;
                if (count >= mcount)
                    return n;
            }
        }
        return -1;
    }

    //hashmap
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length;
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);

            if (count > len / 2)
                return num;
        }

    }

    //selected
    public int majorityElement(int[] num) {

        int major = num[0], count = 1;
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                count++;
                major = num[i];
            } else if (major == num[i]) {
                count++;
            } else count--;

        }
        return major;
    }
    public int majorityElement(int[] nums) {
        int count=0, ret = 0;
        for (int num: nums) {
            if (count==0)
                ret = num;
            if (num!=ret)
                count--;
            else
                count++;
        }
        return ret;
    }
}
