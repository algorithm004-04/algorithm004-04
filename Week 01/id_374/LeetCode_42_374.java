/**
     * 暴力法
     * 时间复杂度：O（n^2）
     *
     * @param height
     * @return
     */
    private int m1(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length - 1; ++i) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = i; j < height.length; ++j) {
                maxRight = Math.max(maxRight, height[j]);
            }
            for (int j = i; j >= 0; --j) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }

    /**
     * 利用栈
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param height
     * @return
     */
    private int m2(int[] height) {
        int ans = 0;
        int current = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.empty()) {
                    break;
                }
                int distance = current - stack.peek() -1;
                int min = Math.min(height[current],height[stack.peek()]);
                ans += distance*(min - h);
            }
            stack.push(current);
            ++current;
        }
        return ans;
    }
