package algorithm.chapter1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 【两数之和】 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 * https://leetcode-cn.com/problems/two-sum/
 * 
 * @author chying
 *
 */
public class LeetCode_1_519 {
	public int[] twoSum(int[] nums, int target) {
		int len = nums.length;
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < len; i++) {
			if (map.containsKey(target - nums[i])) {
				result[0] = map.get(target - nums[i]);
				result[1] = i;
				return result;
			}
			map.put(nums[i], i);
		}
		return result;
	}

	public static void main(String[] args) {
		LeetCode_1_519 a = new LeetCode_1_519();
		int[] result = a.twoSum(new int[] { 2, 7, 11, 15 }, 7);
		System.out.println(Arrays.toString(result));
	}
}
