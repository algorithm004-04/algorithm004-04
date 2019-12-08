import java.util.Stack;

/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

使用栈解法解决问题
1. 对于每一个墙，都要和当前栈顶的墙做对比，如果比栈顶的墙小，则入栈。
如果比栈顶的墙大，则将栈顶元素出栈。然后就能找到左边那个墙

左右墙之间的距离是 右墙-左墙-1
然后用距离再乘以两堵墙最小的那个墙于当前位置的高度差。就能获取到当前这次雨水了
 */
public class LeetCode_42_269 {
    public int trap(int[] height) {
        int maxRain = 0;

        Stack<Integer> stack = new Stack<>();

        for (int right = 0; right < height.length; right++) {

            while (!stack.isEmpty() && height[right] > height[stack.peek()]) {
                int h = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }

                int distance = right - stack.peek() - 1;
                int minHeight = Math.min(height[stack.peek()], height[right]);
                maxRain += (minHeight - h) * distance;
            }

            stack.push(right);
        }
        return maxRain;
    }
}
