
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
//( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
//搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//
// 你可以假设数组中不存在重复的元素。
//
// 你的算法时间复杂度必须是 O(log n) 级别。



class Solution {
    public int search(int[] nums, int target) {
        int low= 0;
        int hi = nums.length - 1;
        while (low < hi) {
            int mid = (low + hi) / 2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {
                low = mid + 1;
            }else {
                hi = mid;
            }
        }

        return  low == hi && nums[low] == target ? low : -1;
    }
}