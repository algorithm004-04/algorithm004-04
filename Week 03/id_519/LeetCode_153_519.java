package algorithm.chapter3.first.binarysearch;

/**
 * 【153. 寻找旋转排序数组中的最小值】假设按照升序排序的数组在预先未知的某个点上进行了旋转。 ( 例如，数组 [0,1,2,4,5,6,7]
 * 可能变为 [4,5,6,7,0,1,2] )。 请找出其中最小的元素。 你可以假设数组中不存在重复元素。 示例 1: 输入: [3,4,5,1,2]
 * 输出: 1 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class LeetCode_153_519 {

	public int findMin(int[] nums) {
		if (null != nums) {
			int left = 0;
			int right = nums.length - 1;
			int mid = 0;
			while (right - 1 > left) {
				mid = left + (right - left) / 2;
				// 发生了旋转，最小值应该在发生旋转了的index范围中
				if ((nums[mid] - nums[left]) * (nums[right] - nums[mid]) < 0) {
					if (nums[mid] - nums[left] < 0) {
						right = mid;
					} else {
						left = mid;
					}

				} else {
					return nums[0];
				}
			}
			return nums[left] < nums[right] ? nums[left] : nums[right];
		}
		return -1;
	}

	public static void main(String[] args) {
		LeetCode_153_519 a = new LeetCode_153_519();
		int[] nums = new int[] { 5, 6, 3, 4 };
		System.out.println(a.findMin(nums));
	}
}
