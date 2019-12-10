// 1. 暴力求解， O(n^2)
// 2. 暴力求解优化， 利用空间换时间策略，提前算好每项的左、右最大值，O(n) 
//    注意：输入数组为空的情况需要考虑清楚
// 3. 利用 栈 来存储左边界的墙，类比 括号匹配


int min(int a, int b)
{
    return (a > b ? b : a);
}

int trap(int* height, int heightSize) {
    int rain = 0;
    int stack[heightSize + 1];
    int top = -1;
    int current = 0;

    if (heightSize <= 0) return 0;

    while (current < heightSize) {
        while (top >= 0 && height[current] > height[stack[top]]) {
            int popHeight = height[stack[top--]];
            if (top < 0)
                break;
            rain += (min(height[current], height[stack[top]]) - popHeight) * (current - stack[top] - 1);
        }
        stack[++top] = current;
        current++;
    }
    return rain;
}

