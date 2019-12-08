import collections


# 单调递减队列法
def maxSlidingWindow(nums, k):
    d = collections.deque()
    res = []
    for i, n in enumerate(nums):
        while d and nums[d[-1]] < n:
            print("loop")
            # print("i, n:", i, n)
            print("d.pop:", d[-1])
            d.pop()
            print("loop end")
        d += i,                     # 相当于把 d.append(i)
        print("d:", d)
        if d[0] == i - k:           # 判断队列左端的值是否为最大值，如果是，就从队列中移除. 同时也维护这窗口的大小i-k
            print("d.popleft:", d[0])
            d.popleft()
        if i >= k - 1:              # 判断是否已经遍历到k下标，因为达到len(k)=3，队列里的最大值才有效（判断右端边界）
            print("i:", i, "\n", "nums[d[0]]:", nums[d[0]])
            res += nums[d[0]],
            print("------------------")
    return res
    # 双端队列 j 作为出队，i 作为入队
    # 队列改变有三种情况：1.入队大于等于栈顶，入栈  2.出入队小于栈顶，不变 3.出队等于栈顶，入队小于栈顶


ex = [7, 2, 4]
e = 2
ex2 = [0]
ex2 += 2,
# print(ex2)
print(maxSlidingWindow(ex, e))

