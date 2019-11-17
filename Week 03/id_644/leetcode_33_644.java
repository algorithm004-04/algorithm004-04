package week03;

/**33
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class search {
    public static void main(String[] args) {

    }
    //这个异或真是难
    public int search_XOR(int[] nums, int target) {
        int left=0,right = nums.length-1;
        while(left< right) {
            int mid = (left+right)/2;
            if((nums[0]>target) ^ (nums[0]>nums[mid]) ^ (target > nums[mid]))
                    left = mid +1;
            else
                    right = mid;
        }
        return left == right && nums[left] == target ? left:-1;
    }
    ///判断 他们三个是不是在同一侧
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            double num = (nums[mid] < nums[0]) == (target < nums[0])
                    ? nums[mid]
                    : target < nums[0] ? Integer.MIN_VALUE: Integer.MAX_VALUE;

            if (num < target)
                lo = mid + 1;
            else if (num > target)
                hi = mid;
            else
                return mid;
        }
        return -1;
    }
    //相同侧的一般性解释
    public int search_sameside(int[] nums, int target) {
        if(nums==null||nums.length==0) return -1;
        int lo = 0;
        int hi = nums.length - 1;
        while(lo<hi)
        {
            int mid = lo + (hi-lo)/2;
            //target and mid are on the same side
            if((nums[mid]-nums[nums.length-1])*(target-nums[nums.length-1])>0)
            {
                if(nums[mid]<target)
                    lo = mid + 1;
                else
                    hi = mid;
            }else if(target>nums[nums.length-1])
                hi = mid; // target on the left side
            else
                lo = mid + 1; // target on the right side
        }
        // now hi == lo
        if(nums[lo]==target)
            return lo;
        else
            return -1;
    }
}
