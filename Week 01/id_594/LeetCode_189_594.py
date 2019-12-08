def rotate(nums, k):        # 但这种方法超时的，O(n*n）
    for i in range(k):
        previous = nums[len(nums)-1]        # 末端元素需要特殊处理
        print("末端元素：", previous)
        for j in range(len(nums)):      # 需要遍历每个元素，因为要针对每个下标的元素进行调整
            temp = nums[j]              # temp 储存当前位置的元素
            print("temp：", temp, '\n', "nums:", nums)
            nums[j] = previous          # 将前一个元素 覆盖 当前元素
            print("nums[j]：", nums[j], '\n', "nums:", nums)
            previous = temp             # 用pre 储存 原本j下标的位置，用于覆盖下次循环 j+1 的元素
            print("previous:", previous, '\n', "nums:", nums)
            print("------------------------------------------")
    return nums


def rotate2(nums, k):
    n = len(nums)
    k = k % n          # 数组中，包含多少步（圈）
    print("k:", k)
    print("nums[n-k:],", nums[n-k:], "nums[:n-k]:", nums[:n-k])
    nums[:] = nums[n-k:] + nums[:n-k]
    return nums


ex = [1, 2, 3, 4, 5]
print(rotate2(ex, 3))

