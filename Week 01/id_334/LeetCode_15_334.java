package Array;
//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
// Note:
//
// The solution set must not contain duplicate triplets.
//
// Example:
//
//
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
// Related Topics Array Two Pointers -> 原本还没有很好的思路，一看到这行就瞬间茅塞顿开，好好审题很重要！

// 第一个想法V1：先排序保证有序，目的是为了移动下标有序&&避免计算重复&&避免重复；这里使用了双指针
//     匹配原则： (1) i + lo  + hi < 0 ; lo ++ (2) i + lo  + hi > 0 ; hi -- (3) i + lo + hi ==0 ; lo++;hi--
//     去重原则：(1) 由于lo=i+1,因此外循环要过滤掉nums[i]=num[i-1]（两者等价） (2) 内循环同理，注意使用双端指针收敛是，对于已成立的组合要避免重复计算，考虑临界情况比如连续的-2,-2,-2,-2情况
//      时间复杂度O(n^2)  至于暴力破解法的三层嵌套循环就不讲了，时间复杂度为O(n^3)


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_15_334 {

    public static void main(String[] args) {
        int nums[] = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        List<List<Integer>> result = threeSumV1(nums);
        System.out.println(result);
    }

    /**
     * Runtime: 26 ms, faster than 97.60% of Java online submissions for 3Sum.
     * Memory Usage: 47.5 MB, less than 86.57% of Java online submissions for 3Sum.
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSumV1(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0){
                break;
            }
            if (i == 0 || nums[i] != nums[i - 1])
                for (int lo = i + 1, hi = nums.length - 1; lo < hi; ) {
                    int sum = nums[i] + nums[lo] + nums[hi];
                    if (sum < 0) {
                        lo++;
                        continue;
                    }
                    if (sum > 0) {
                        hi--;
                        continue;
                    }
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    if (lo != hi) {
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    }
                }
        }
        return result;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
