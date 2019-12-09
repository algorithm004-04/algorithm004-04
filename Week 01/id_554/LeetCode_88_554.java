package com.kkkkkk.demovvorld.leetcode88;

import com.alibaba.fastjson.JSON;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1;
        int q = n - 1;
        for (int i = m + n - 1; i > 0 && p >= 0 && q >= 0; --i) {
            if (nums1[p] > nums2[q]) {
                nums1[i] = nums1[p];
                --p;
            } else {
                nums1[i] = nums2[q];
                --q;
            }
        }

        System.arraycopy(nums2, 0, nums1, 0, q + 1);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 7, 0, 0, 0, 0, 0, 0, 0};
        int[] nums2 = new int[]{6, 9, 10, 12};

        new Solution().merge(nums1, 3, nums2, nums2.length);

        System.out.println(JSON.toJSONString(nums1));
    }
}