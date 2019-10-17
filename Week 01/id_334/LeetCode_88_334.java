package Array;
//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
// Note:
//
//
// The number of elements initialized in nums1 and nums2 are m and n respectively.
// You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
//
//
// Example:
//
//
//Input:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [4,5,6],       n = 3

// 1

//Output: [1,2,2,3,5,6]
//
// Related Topics Array Two Pointers

// 第一个想法V1：合并后排序即可，时间复杂度是O((n+m)(log(n+m)))，空间复杂度为o(1)

// 第二个想法V2: 双指针尾移法，用i和j分别nums1和nums2 的尾部移动下标，对比值，哪个比较小就往前移动，然后从nums1[m+n-1]开始填充
//              这样就避免了从前往后移动时，当出现多个nums2的值小于nums1的值时，需要额外空间去处理nums1同下标的值
//              这个做法需要考虑一种临界情况：原nums1[0] > nums2的前N个元素，这说明当i遍历结束为0时，nums[2]还有元素没有补充，
//              由于nums[2]是天然有序的，因此从0长度开始直接填充j+1长度即可
//              时间复杂度是O(m+n),空间复杂度是O(1)

// 第二个想法V3: 想法2是从后往前，该想法就是从前往后，那么就需要考虑存储因多个nums2值小于nums1值时的额外空间存储nums1的元素
//              时间复杂度是O(m+n) 空间复杂度是O(m)


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_88_334 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
//        int[] nums1 = new int[]{2,0};
//        int[] nums2 = new int[]{1};
//        mergeV3(nums1,1,nums2,1);

        int[] nums2 = new int[]{4, 5, 6};
        mergeV2_1(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void mergeV1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
     * Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Merge Sorted Array.
     */
    public static void mergeV2(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (m >= 0 && n >= 0) {
//            if (nums1[m] < nums2[n]){
//                nums1[last--] = nums2[n--];
//                continue;
//            }
//            nums1[last--] = nums1[m--];
//            以上合并为三目表达式
            nums1[last--] = nums1[m] < nums2[n] ? nums2[n--] : nums1[m--];
        }
        System.arraycopy(nums2, 0, nums1, 0, n + 1);
    }

    /**
     * super cool code
     * 基于mergeV2简化，核心点在于变更了m和n的判断条件以及随之的变动
     */
    public static void mergeV2_1(int[] nums1, int m, int[] nums2, int n) {
        while (n > 0) nums1[m + n - 1] = (m == 0 || nums2[n - 1] > nums1[m - 1]) ? nums2[--n] : nums1[--m];
    }

    public static void mergeV3(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m];
        System.arraycopy(nums1, 0, nums, 0, m);

        int x = 0;
        int y = 0;
        int z = 0;

        while (x < m && y < n) {
            nums1[z++] = (nums[x] < nums2[y]) ? nums[x++] : nums2[y++];
        }
        //填充剩余的
        int begin = x + y;
        int len = m + n - begin;

        if (x < m)
            System.arraycopy(nums, x, nums1, begin, len);
        if (y < n)
            System.arraycopy(nums2, y, nums1, begin, len);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
