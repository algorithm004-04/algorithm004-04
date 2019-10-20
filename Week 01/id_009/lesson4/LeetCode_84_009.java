package lesson4;

import java.util.Stack;

/**
 * 【柱状图中最大的矩形】
 * <p>
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */

public class LeetCode_84_009 {
    public static void main(String[] args) {
        LeetCode_84_009 test = new LeetCode_84_009();
//        int[] nums = {2, 1, 5, 6, 2, 3};
        int[] nums = {4, 4, 5, 4, 1, 2};
        System.out.println(test.largestRectangleArea3(nums));
    }


    /**
     * 方法一：暴力法 求取两个柱子间的面积(运行超时)
     * 1）loop， 求取left bound 和 right bound之间的面积
     * 2）更新max-area
     * <p>
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(1)
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int minHeight = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    minHeight = Math.min(minHeight, heights[k]);
                }
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }


    /**
     * 方法二：暴力优化
     * 在方法一的基础上，可以在知道前一次最低高度的情况下，直接比较当前柱子高度和之前结果中最低柱子高度，获得当前最低高度。
     * <p>
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }

    /**
     * 方法三：使用栈
     * <p>
     * 栈从下到上 存储 递增数据的下标
     * <p>
     * 关键是：每个柱子组成的矩形由：左侧距离它最近的比它小的元素的下标 和  右侧距离它最近的比它小的元素的下标 决定。
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度: O(n)
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea3(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxarea;
    }

}
