import java.util.Stack;

public class LeetCode_42_029 {
	public int trap(int[] height) {
		int sum = 0;
		Stack<Integer> stack = new Stack<>();
		int current = 0;
		while (current < height.length) {
			// 如果栈不空并且当前指向的高度大于栈顶高度就一直循环
			while (!stack.empty() && height[current] > height[stack.peek()]) {
				// 取出要出栈的元素
				int h = height[stack.peek()];
				// 出栈
				stack.pop();
				if (stack.empty()) { // 栈空就出去
					break;
				}
				// 两堵墙之前的距离。
				int distance = current - stack.peek() - 1;
				int min = Math.min(height[stack.peek()], height[current]);
				sum = sum + distance * (min - h);
			}
			// 当前指向的墙入栈
			stack.push(current);
			// 指针后移
			current++;
		}
		return sum;
	}
}