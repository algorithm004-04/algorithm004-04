package com.chief;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_42_289 {

    public int trap(int[] height) {
        int sum = 0;
        int max = getMax(height);
        for (int i = 1; i <= max; i++) {
            boolean isStart = false;
            int tempSum = 0;
            for (int aHeight : height) {
                if (isStart && aHeight < i) {
                    tempSum++;
                }
                if (aHeight >= i) {
                    sum = sum + tempSum;
                    tempSum = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }

    private int getMax(int[] height) {
        int max = 0;
        for (int aHeight : height) {
            if (aHeight > max) {
                max = aHeight;
            }
        }
        return max;


    }
}
