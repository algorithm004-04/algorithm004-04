package alg;

import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 *
 *
 * @author zhaoyang on 2019-10-20.
 */
public class TrapRainWater {

  public int trap(int[] heights) {
    if (heights == null || heights.length < 2) return 0;

    Stack<Integer> stack = new Stack<>();
    int i = 0, water = 0;
    while (i < heights.length) {
      if (stack.isEmpty() || heights[i] <= heights[stack.peek()]) {
        stack.push(i++);
      } else {
        int pre = stack.pop();
        if (!stack.isEmpty()) {
          int minHeight = Math.min(heights[stack.peek()], heights[i]);
          water += (minHeight - heights[pre]) * (i - stack.peek() - 1);
        }
      }
    }
    return water;
  }

  public static void main(String[] args) {
    int[] heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println(new TrapRainWater().trap(heights));
  }

}
