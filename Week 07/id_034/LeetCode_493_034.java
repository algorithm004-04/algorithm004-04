import java.util.Arrays;

/**
 * LeetCoode_493_034
 *
 * @Author blackberry
 * @Date 2019/12/1 2:04 PM
 **/
public class LeetCode_493_034 {

    public int ret;
    public int reversePairs(int[] nums) {
        ret = 0;
        mergeSort(nums, 0, nums.length - 1);
        return ret;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid );
        mergeSort(nums, mid + 1, right);

        int count = 0;
        for (int i = left, j = mid + 1; i <= mid; ) {
            if (j > right || nums[i] / 2.0 <= nums[j]) {
                i ++;
                ret += count;
            } else {
                j ++;
                count ++;
            }
        }
        Arrays.sort(nums, left, right + 1);
    }
}
