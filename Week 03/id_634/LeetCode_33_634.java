class Solution {
    //1.二分法
    // public int search(int[] nums, int target) {
    //     if (nums == null || nums.length == 0) return -1;
    //     int left = 0, right = nums.length - 1;
    //     while (left <= right) {
    //         int mid = (left + right) / 2;
    //         if (nums[mid] == target) {
    //             return mid;
    //         } else if (nums[mid] < nums[right]) {
    //             if (target > nums[mid] && target <= nums[right]) {
    //                 left = mid + 1;
    //             } else {
    //                 right = mid - 1;
    //             }
    //         } else {
    //             if (target >= nums[left] && target < nums[mid]) {
    //                 right = mid - 1;
    //             } else {
    //                 left = mid + 1;
    //             }
    //         }
    //     }
    //     return -1;
    // }
    
    //2.位查询
    // public int search(int[] nums, int target) {
    //    int left = 0, right = nums.length - 1;
    //    while (left < right) {
    //        int mid = (left + right) / 2;
    //        if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
    //            left = mid + 1;
    //        else
    //            right = mid;
    //    }
    //    return left == right && nums[left] == target ? left : -1;
    // }
    
    //3.二分法
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left]) {
                if (target <= nums[mid] && target >= nums[left]) right = mid;
                else left = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }
}