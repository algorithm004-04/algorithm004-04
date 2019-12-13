package Array;
//Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
// Note: You may not slant the container and n is at least 2.
//
//
//
//
//
// The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
//
//
//
// Example:
//
//
//Input: [1,8,6,2,5,4,8,3,7]
//Output: 49
// Related Topics Array Two Pointers

// 第一个想法V1：（下意识最简答粗暴的)穷举法，把每个长宽都乘一遍（相当于组合题-n数中选2个乘积最大的），注意是最短高度；时间复杂度是O(n^2)
// 第一个想法V2： V1的嵌套计算了所有情况，优化的方案是尽可能消去计算的组合；
//              该法的数学依据在于： n为数组长度，则H[lo]与H[hi]中至少有一个是在(0,lo]和[hi,n-1)中，H最大的；
//              双指针收敛夹击法有个技巧在于只移动短下标,因为在都移动了1位的情况下，还是取短下标的高度，因此移动高下标无意义
//              时间复杂度为O(n^2)

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_11_344 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxAreaV2(array));
    }

    public static int maxAreaV1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int lo = 0; lo < height.length - 1; lo++) {
            for (int hi = lo + 1; hi < height.length; hi++) {
                maxArea = Math.max(maxArea, (hi - lo) * Math.min(height[hi], height[lo]));
            }
        }
        return maxArea;
    }

    public static int maxAreaV2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0, lo = 0, hi = height.length - 1;
        while (lo < hi) {
            int min = height[lo] < height[hi] ? height[lo++] : height[hi--];
            maxArea = Math.max(maxArea, (hi - lo + 1) * min);
        }
        return maxArea;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
