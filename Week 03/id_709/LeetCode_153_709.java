package medium;
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
// 请找出其中最小的元素。
//
// 你可以假设数组中不存在重复元素。
//
// 示例 1:
//
// 输入: [3,4,5,1,2]
//输出: 1
//
// 示例 2:
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0
// Related Topics 数组 二分查找


public class LC153 {

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,1,2,3};
        int ind1 = findMin(nums);
        System.out.println(ind1);

    }

    public static  int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length;

        if(nums[hi-1] > nums[lo]){
            return nums[0];
        }

        while(lo<hi){
            int mid = (lo+hi)/2;
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid-1]>nums[mid]){
                return nums[mid];
            }

            if(nums[mid]>nums[lo]){
                lo = mid+1;
            }else{
                hi = mid -1;
            }
        }

        return -1;
    }
}
