package algorithm.chapter2.second;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 【169. 求众数】给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。 示例 1: 输入: [3,2,3] 输出: 3 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 
 * @author chying
 *
 */
public class LeetCode_169_519 {
	/**
	 * 常规方法，使用hashmap
	 * 
	 * @param nums
	 * @return
	 */
	public int majorityElement1(int[] nums) {
		int len = nums.length / 2;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
			if (map.get(num) > len) {
				return num;
			}
		}
		return 0;
	}

	/**
	 * 排序，n/2位置 为众数
	 * 
	 * @param nums
	 * @return
	 */
	public int majorityElement2(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	/**
	 * 众数一定是数组中出现次数大于n/2的数
	 * 
	 * @param nums
	 * @return
	 */
	public int majorityElement3(int[] nums) {
		int majority = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == majority) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				majority = nums[i];
				count = 1;
			}
		}
		return majority;
	}

	/**
	 * 分治---其实没太明白
	 * 
	 * @param nums
	 * @return
	 */
	public int majorityElement4(int[] nums) {
		return majorityElementHalf(nums, 0, nums.length - 1);
	}

	private int majorityElementHalf(int[] nums, int lo, int hi) {
		if (lo == hi) {
			return nums[lo];
		}
		int mid = (hi - lo) / 2 + lo;
		int left = majorityElementHalf(nums, lo, mid);
		int right = majorityElementHalf(nums, mid + 1, hi);

		if (left == right) {
			return left;
		}

		int leftCount = countInRange(nums, left, lo, hi);
		int rightCount = countInRange(nums, right, lo, hi);

		return leftCount > rightCount ? left : right;
	}

	private int countInRange(int[] nums, int num, int lo, int hi) {
		int count = 0;
		for (int i = lo; i <= hi; i++) {
			if (nums[i] == num) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		LeetCode_169_519 a = new LeetCode_169_519();
		int[] nums = new int[] { 3, 2, 3 };
		System.out.println(a.majorityElement4(nums));
	}
}
