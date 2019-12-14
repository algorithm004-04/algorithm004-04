class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while (left <= right && left < nums.length) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid])
                return mid;
            if (nums[left] <= nums[mid] && nums[left] <= target && target <= nums[mid])
                right = mid;
            else if (nums[left] <= nums[mid])
                left = mid + 1;
            else if (nums[right] >= nums[mid] && nums[mid] <= target && target <= nums[right])
                left = mid;
            else
                right = mid - 1;
        }
        return -1;
    }
}
