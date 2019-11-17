package algorithm;

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
//( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
//搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//
//你可以假设数组中不存在重复的元素。
//
//你的算法时间复杂度必须是 O(log n) 级别。
//
//示例 1:
//
//输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
//示例 2:
//
//输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class LeetCode_33_299 {
    public static int search(int[] nums, int target) {
        // 在一组给定的数组中找到 某个target值， 时间复杂度 logn 使用二分查找
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            // 取中索引
            int mid = (left + right) >>>1;
            // 判断中值 三个条件需要满足
            if((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])){
                left = mid +1;
            } else {
                right = mid;
            }
        }

        return (left == right) && target == nums[left] ? left : -1;
    };

    public static void main(String[] args) {
        int[] array = new int[]{5,1,3};
        int s = LeetCode_33_299.search(array,3);
        System.out.println("target -------->"+s);
    }
}
