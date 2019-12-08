package week_03.lesson11;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                low = mid + 1;
            } else if(target > nums[mid] && target < nums[0]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (low == high && nums[low] == target) {
            return low;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

    }

}
