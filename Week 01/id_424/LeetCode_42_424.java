package com.wangyao.Trapping_Rain_Water;

import java.util.LinkedList;

/**
 * @Author: Ori
 * @Time: 2019/10/20
 */
public class Solution {
    public int trap(int[] height) {
        LinkedList<Integer> stack = new LinkedList<>();
        int cap = 0;
        for (int i = 0; i < height.length; i++) {
            while (stack.size() > 0 && height[i] > height[stack.peekFirst()]) {
                int top = stack.pollFirst();
                if (stack.isEmpty())
                    break;
                int wid = i - stack.peekFirst() - 1;
                int height_dif = Math.min(height[stack.peekFirst()], height[i]) - height[top];
                cap += height_dif * wid;
            }
            stack.push(i);
        }
        return cap;
    }
}
