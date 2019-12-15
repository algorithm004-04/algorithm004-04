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

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n];
        int k1 = 0;
        int k2 = 0;
        int k3 = 0;
        while(k2 < m && k3 < n) {
            if(nums1[k2] <= nums2[k3]) {
                temp[k1++] = nums1[k2++];
            }else {
                temp[k1++] = nums2[k3++];
            }
        }

        while(k2 < m) {
            temp[k1++] = nums1[k2++];
        }

        while(k3 < n) {
            temp[k1++] = nums2[k3++];
        }

        for(int i=0; i < temp.length;i++) {
            nums1[i] = temp[i];
        }
    }
}


//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        //从后往前添加元素,不需要额外空间
//        int p1 = m - 1;
//        int p2 = n - 1;
//        int p = m + n -1;
//        while (p1 >= 0 && p2 >= 0) {
//            //放入大的哪一个元素
//            if(nums1[p1] <= nums2[p2]) {
//                nums1[p--] = nums2[p2 --];
//            }else {
//                nums1[p--] = nums1[p1 --];
//            }
//        }
//
//        while (p1 >= 0) {
//            nums1[p--] = nums1[p1--];
//        }
//
//        while (p2 >= 0) {
//            nums1[p--] = nums2[p2--];
//        }
//    }