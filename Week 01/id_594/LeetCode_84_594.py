def largestRectangleArea(heights):
    # stack = []
    # MaxArea = 0
    # stack.append(heights[0])
    # print(stack)
    # for i in range(1, len(heights)):
    #     while heights[i] < stack[-1]:     这个判断真是笨
    #         top = stack.pop()
    #         MaxArea = max(MaxArea, top * (i - i-1 - 1))
    #     stack.append(heights[i])
    # j = 0
    # while len(stack) < 1:
    #     # 当stack栈堆还有元素，计算每个bond的面积
    #     top = stack.pop()
    #     j += 1
    # MaxArea = max(MaxArea, top * j)
    # return MaxArea

    heights.append(0)       # 这一步真是举世无双啊
    print(heights)
    stack = [-1]
    maxarea = 0
    for i in range(len(heights)):
        print("i:", i)
        print("heights[i]:", heights[i], "<", "heights[stack[-1]]:", heights[stack[-1]])
        while heights[i] < heights[stack[-1]]:
            print("步骤：A")
            print("栈顶元素：", stack[-1])
            top = heights[stack.pop()]
            print("pop的元素高:", top)
            print("-------------------")
            maxarea = max(maxarea, top * (i - stack[-1] - 1))       # (i - stack[-1] - 1) 这个计算宽度的面积，还是不明白
        stack.append(i)
        print("B")
        print("-------------------")
    heights.pop(0)
    return maxarea


ex = [2, 1, 5, 6, 2, 3]
print(largestRectangleArea(ex))

