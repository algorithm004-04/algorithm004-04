package SuanFa.Week07;

import java.util.Arrays;

/**
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 *
 *
 * 示例 2:
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 *
 *
 * 注意:
 *
 *
 * 	给定数组的长度不会超过50000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_493_574 {

    public static void main(String[] args) {
        int nums[] = {2,4,3,5,1};
        System.out.println(reversePairs(nums));
    }
    private static int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }

    private static int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = left + (right - left)/2;
        int count = mergeSort(nums,left,mid) + mergeSort(nums,mid+1,right);
        for (int i =left, j = mid+1; i<= mid;i++) {
            while (j<= right && nums[i]/2.0 > nums[j]) j++;
            count += j-(mid+1);
        }
        Arrays.sort(nums,left,right+1);
        return count;
    }

    //method2
    private static int ret;
    private static int reversePairs1(int[] nums) {
        ret = 0;
        mergeSort1(nums,0,nums.length-1);
        return ret;
    }

    private static void mergeSort1(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }

        int mid = left + (right - left)/2;
        mergeSort1(nums,left,mid);
        mergeSort1(nums,mid+1,right);
        int count = 0;
        for (int l = left, r = mid+1; l <= mid;) {
            if (r > right || (long)nums[l] <= 2*(long)nums[r]) {
                l++;
                ret += count;
            }
            else {
                r++;
                count++;
            }
        }
        Arrays.sort(nums,left,right+1);
    }

    private static int mergeSort2(int[]nums, int l, int r) {
        if (l >= r) return 0;
        int mid = l + (r-l)/2;
        int count = mergeSort2(nums,l,mid) + mergeSort2(nums,mid+1,r);
        int[] cache = new int [r - l +1];
        int i = l, t = l, c = 0;
        for (int j = mid + 1; j <= r;j++,c++) {
            while (i <= mid && nums[i] <= 2 * (long)nums[j]) i++; // 统计
            while (t <=mid && nums[t] < nums[j]) cache[c++] = nums[t++]; //合并
            cache[c] = nums[j];
            count += mid-i+1;
        }
        while (t <= mid) cache[c++] = nums[t++];
        System.arraycopy(cache,0,nums,l,r-l+1);
        return count;
    }

}
