//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
//
// 示例:
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6
// Related Topics 栈 数组 双指针


import java.util.Stack;

public class LeetCode_42_154 {
    //    1. 暴力求解
//    public int trap(int[] height) {
//        int ans = 0;
//        for (int i = 1; i < height.length - 1; i++) {
//            int maxLeft = 0;
//            int maxRight = 0;

// 包括当前柱子， 如果当前柱子是最高的，高度差为0. 如果不包括当前柱子，高度差可能为负数。
//            for (int j = i; j >= 0; j--) {
//                maxLeft = Math.max(maxLeft, height[j]);
//            }
//
//            for (int j = i; j < height.length; j++) {
//                maxRight = Math.max(maxRight, height[j]);
//            }
//
//            ans = ans + Math.min(maxLeft,maxRight) - height[i];
//
//        }
//        return ans;
//    }

//    2. 栈方法
    public int trap(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int h = height[stack.pop()];
                if (stack.empty()) break;

                int distance = i - stack.peek() - 1;
                int minHeight = Math.min(height[stack.peek()], height[i]);

                ans = ans + distance * (minHeight - h);
            }

            stack.push(i);

        }

        return ans;
    }
}
