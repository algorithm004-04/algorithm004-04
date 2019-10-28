package algorithm.chapter2.first;

import java.util.ArrayList;
import java.util.List;

/**
 * 【46. 全排列】给定一个没有重复数字的序列，返回其所有可能的全排列。 示例: 输入: [1,2,3] 输出: [ [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], [3,2,1] ] 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 
 * @author chying
 *
 */
public class LeetCode_46_519 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> templist = new ArrayList<>();
		backtrace(result, nums, templist);
		return result;
	}

	private void backtrace(List<List<Integer>> result, int[] nums, List<Integer> templist) {
		if (templist.size() == nums.length) {
			result.add(new ArrayList<>(templist));
		} else {
			for (int num : nums) {
				if (templist.contains(num)) {
					continue;
				}
				templist.add(num);
				backtrace(result, nums, templist);
				templist.remove(templist.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		LeetCode_46_519 a = new LeetCode_46_519();
		int[] nums = new int[] { 1, 2, 3 };
		List<List<Integer>> result = a.permute(nums);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}
}
