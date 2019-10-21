//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1.合并后排序
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        //m为nums1中有效元素的个数
        //将nums2数组里从索引为0的元素开始, 复制到数组nums1里的索引为m(num1的末尾)的位置, 复制的元素个数为m(num1的长度)个
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    //2.双指针法(前插）
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //注意：int[] num1_copy=nums1不能用来创建新数组，
        // 它的含义是将nums1_copy指向num1,修改nums1_copy时也修改了nums1
        int[] nums1_copy = new int[m];
        //由于nums1要用来输出，这里copy一个nums1用于与nums2比较,将较小的结果一次放入nums1
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        //定义两个指针分别指向nums1_copy和nums2
        int p1 = 0, p2 = 0;
        //定义一个指针指向num1
        int pointer = 0;
        //终止条件为p1或p2遍历完当前数组
        while (p1 < m && p2 < n) {
            nums1[pointer++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++];
        }
        if (p1 < m) {
            //表示p2已经遍历完，需要将nums1_copy从下标为p1开始，到末尾结束的m+n-p1-p2个元素copy到num1末尾(p1+p2)
            System.arraycopy(nums1_copy, p1, nums1, p1+p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            //表示p1已经遍历完，需要将nums2从下标从p2开始，到末尾结束的m+n-p1-p2(总长度减去已插入元素)个元素copy到num1末尾(p1+p2)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }

    //双指针（后插）
    public void merge(int[] nums1, int m, int[] nums2, int n) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)
