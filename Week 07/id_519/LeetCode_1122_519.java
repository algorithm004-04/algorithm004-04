package algorithm.chapter7.template;

import java.util.Arrays;

/**
 * 【1122数组的相对排序】给你两个数组，arr1 和 arr2， arr2 中的元素各不相同 arr2 中的每个元素都出现在 arr1 中 对
 * arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class LeetCode_1122_519 {
	/**
	 * 计数排序
	 * 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		if (null != arr2) {
			int[] arr = new int[1001];
			for (int num : arr1) {
				arr[num]++;
			}
			int count = 0;
			for (int num : arr2) {
				while (arr[num]-- > 0) {
					arr1[count++] = num;
				}
			}
			for (int i = 0; i < arr.length; i++) {
				while (arr[i]-- > 0) {
					arr1[count++] = i;
				}
			}
		}
		return arr1;
	}

	public static void main(String[] args) {
		LeetCode_1122_519 a = new LeetCode_1122_519();
		int[] arr1 = new int[] { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
		int[] arr2 = new int[] { 2, 1, 4, 3, 9, 6 };
		System.out.println(Arrays.toString(a.relativeSortArray(arr1, arr2)));
	}
}
