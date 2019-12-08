# NOTE

本周最重要的内容 二分查找的模板
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1



//查找半序数组的，无序部分。其实找最小值的那道题没什么区别
public static int findreverse(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0;
        int hi = nums.length - 1;
        if (nums[hi] > nums[0]) {
            return nums[0];
        }
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else
                hi = mid - 1;
        }
        return nums[lo];
    }
  

