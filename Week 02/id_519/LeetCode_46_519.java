package algorithm.chapter2.first;

import java.util.ArrayList;
import java.util.List;

/**
 * ��46. ȫ���С�����һ��û���ظ����ֵ����У����������п��ܵ�ȫ���С� ʾ��: ����: [1,2,3] ���: [ [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], [3,2,1] ] ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/permutations
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
