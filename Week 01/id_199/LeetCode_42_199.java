package com.wujunze.Trapping_Rain_Water;

import java.util.LinkedList;

class Solution {
    public int trap(int[] height) {
        if (null == height || 0 == height.length){
            return 0;
        }
        int area = 0;
        int left = 0; // 左边界
        int right = height.length - 1; // 右边界
        int left_max = height[left];
        int right_max = height[right];
        while (left <= right) {
            // 左边低于右边 则从左边开始计算
            if (left_max <= right_max){
                // 没有高于左边最大值 则可以蓄水
                if (left_max >= height[left]){
                    area += (left_max - height[left]);
                } else {
                    left_max = height[left];
                }
                left++;
            } else {
                // 从右边开始计算
                // 没有高于右边最大值 则可以蓄水
                if (right_max >= height[right]){
                    area += (right_max -height[right]) ;
                } else {
                    right_max  = height[right];
                }
                right--;
            }
        }
        return area;
    }
}