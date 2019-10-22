import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: wangchuande
 * @Date: 2019/10/20 20:37
 */
public class LeetCode_42_314 {
    public int trap(int[] height) {
        int count = 0;
        if (height.length == 0) {
            return count;
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < height.length; i++) {
            int currentValue = height[i];
            if (stack.isEmpty() || currentValue <= height[stack.peek()]) {
                stack.push(i);
                continue;
            }

            while (currentValue > height[stack.peek()]) {
                int bottom = stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    count += (Math.min(height[stack.peek()], currentValue) - height[bottom]) * (i - stack.peek() - 1);
                }
            }

            stack.push(i);

        }

        return count;
    }

    public static void main(String[] args) {
        LeetCode_42_314 leetCode42314 = new LeetCode_42_314();
//        int[] testData = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] testData = new int[]{2, 1, 0, 2};
        int[] testData = new int[]{5,2,1,2,1,5};
        int expected = 14;
        leetCode42314.trap(testData);

        System.out.println("Is Pass: " + (leetCode42314.trap(testData) == expected));
    }
}
