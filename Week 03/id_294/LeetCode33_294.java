package week03;

//搜索旋转排序数组
import java.util.*;

public class LeetCode33_294 {

    /**
     * 分 target == [mid]  target < [mid]  target > [mid] 三种情况
     * [left] < [mid] 表示 [left ~ mid]区间是有序的, 同理 [mid] < [right]
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
//                System.out.println("left " + left + " right " + right + " mid " + mid);
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
               if (nums[left] <= nums[mid]) {
                    if (nums[left] <= target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
               } else {
                   right = mid - 1;
               }
            }
            if (target > nums[mid]) {
                if (nums[mid] <= nums[right]) {
                    if (target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 光头哥解法
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = (target < nums[0]) == (nums[mid] < nums[0]) ? nums[mid] : target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            if (num < target) {
                left = mid + 1;
            } else if(num > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * most voted
     * 先求出最小的值的索引，作为旋转的长度
     * 每次计算出mid后，加上旋转的长度作为实际的mid
     * @param nums
     * @param target
     * @return
     */
    public int search3(int[] nums, int target) {
        //find smallest value
        int length = nums.length;
        int left = 0;
        int right = length-1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int offset = left;
        left = 0;
        right = length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            int realMid = (mid + offset) % length;
            if (target == nums[realMid]){
                return realMid;
            } else if (target < nums[realMid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{4,5,6,7,0,1,2};
        int[] arr = new int[]{4,5,6,7,8,1,2,3};
        int index = new LeetCode33_294().search3(arr, 8);
        System.out.println(index);
    }
}
