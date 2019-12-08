// 1. ������⣬ O(n^2)
// 2. ��������Ż��� ���ÿռ任ʱ����ԣ���ǰ���ÿ����������ֵ��O(n) 
//    ע�⣺��������Ϊ�յ������Ҫ�������
// 3. ���� ջ ���洢��߽��ǽ����� ����ƥ��


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

