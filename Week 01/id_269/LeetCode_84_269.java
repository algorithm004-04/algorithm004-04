import java.util.Stack;

/*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class LeetCode_84_269 {
    public int largestRectangleArea(int[] heights) {

        int maxArea = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < heights.length; i++) {

            //栈中元素大于等于当前数组元素，出栈操作
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            //右边界是数组长度，左边界是stack.peek
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }

        return maxArea;
    }

    public int largestRectangleArea1(int[] heights) {

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int leftBound = i;
            int rightBound = i;

            while (leftBound >= 0 && heights[leftBound] >= heights[i]) {
                leftBound--;
            }

            while (rightBound < heights.length && heights[rightBound] >= heights[i]) {
                rightBound++;
            }

            int currentArea = (rightBound - leftBound - 1) * heights[i];
            maxArea = Math.max(currentArea, maxArea);
        }

        return maxArea;
    }
}
