class Solution {
    
    //第四遍使用双指针，遍历一次找到最大容积
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int result = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    result += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    result += (right_max - height[right]);
                }
                --right;
            }
        }
        return result;
    }
    
    //第三遍使用栈，遍历一次找到最大容积
    // public int trap(int[] height) {
    //     int result = 0, current = 0;
    //     Stack<Integer> stack = new Stack<Integer>();
    //     while (current < height.length) {
    //         while (!stack.empty() && height[current] > height[stack.peek()]) {
    //             int top = stack.peek();
    //             stack.pop();
    //             if (stack.empty())
    //                 break;
    //             int distance = current - stack.peek() - 1;
    //             int bounded_height = (height[current] < height[stack.peek()] ? height[current] : height[stack.peek()]) - height[top];
    //             result += distance * bounded_height;
    //         }
    //         stack.push(current++);
    //     }
    //     return result;
    // }

    //第二遍缓存最大值，分别遍历每个柱子找到最大容积
    // public int trap(int[] height) {
    //     if(height.length == 0) {
    //         return 0;
    //     }
    //     int result = 0;
    //     int size = height.length;
    //     int[] left_max = new int[size];
    //     int[] right_max = new int[size];
    //     left_max[0] = height[0];
    //     for (int i = 1; i < size; i++) {
    //         left_max[i] = height[i] > left_max[i - 1] ? height[i] : left_max[i - 1];
    //     }
    //     right_max[size - 1] = height[size - 1];
    //     for (int i = size - 2; i >= 0; i--) {
    //         right_max[i] = height[i] > right_max[i + 1] ? height[i] : right_max[i + 1];
    //     }
    //     for (int i = 1; i < size - 1; i++) {
    //         result += (left_max[i] < right_max[i] ? left_max[i] : right_max[i]) - height[i];
    //     }
    //     return result;
    // }
    
    //第一遍暴力破解，嵌套遍历每个柱子找到最大容积
    // public int trap(int[] height) {
    //     int result = 0;
    //     int size = height.length;
    //     for (int i = 1; i < size - 1; i++) {
    //         int max_left = 0, max_right = 0;
    //         for (int j = i; j >= 0; j--) { //查找左边最高柱子
    //             max_left = max_left > height[j] ? max_left : height[j] ;
    //         }
    //         for (int j = i; j < size; j++) { //查找右边最高柱子
    //             max_right = max_right > height[j] ? max_right : height[j];
    //         }
    //         result += (max_left < max_right ? max_left : max_right) - height[i];
    //     }
    //     return result;
    // }
}