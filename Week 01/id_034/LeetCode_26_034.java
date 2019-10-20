/**
 * 删除重复数组
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/submissions/
 *
 * @Author blackberry
 * @Date 2019/10/17 10:00 PM
 **/
public class RemoveDuplicatesFromSortedArray {

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int deleteDuplicates(int[] nums) {
        int len = nums.length;

        if (len <= 1) {
            return len;
        }

        int j = 0;
        for (int i = 1; i < length; i ++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }

        return j + 1;
    }
}
