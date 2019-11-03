package algorithm.homework.week03;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 你可以假设数组中不存在重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_153_374 {
    public static void main(String[] args) {

    }

    /**
     * 二分查找
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[right] > nums[0]) {
            return nums[0];
        }
        while (right >= left) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[mid +1]) {
                return nums[mid +1];
            }
            if (nums[mid - 1] >nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                left = mid +1;
            }else {
                right = mid -1;
            }
        }
        return  -1;
    }
}
