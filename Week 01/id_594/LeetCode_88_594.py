def merge(nums1, m, nums2, n):
    # nums1_copy = nums1[:m]
    # nums1[:] = []
    # i, j = 0, 0
    # while i < m and j < n:
    #     if nums1_copy[i] < nums2[j]:
    #         print(" nums1_copy[i] < nums2[j]")
    #         print(" 1copy:", nums1[i], "\n", "2:", nums2[j])
    #         nums1.append(nums1_copy[i])
    #         print("--------------------")
    #         i += 1
    #     else:
    #         print(" nums1_copy[i] > nums2[j]")
    #         print(" 1copy:", nums1[i], "\n", "2:", nums2[j])
    #         nums1.append(nums1_copy[j])
    #         print("--------------------")
    #         j += 1
    #
    #     if i < m:
    #         nums1[n + m:] = nums1_copy[i:]
    #     if i < n:
    #         nums1[n + m:] = nums2[n:]
    # return nums1

    while m > 0 and n > 0:              # 这个方法是从最大值开始往前推，m，n大于0 是循环条件
        if nums1[m-1] >= nums2[n-1]:    # m+n-1 就是有效元素的总和长度，也就是最终有效的排序数组
            nums1[m+n-1] = nums1[m-1]   # 得到大元素，就塞到nums1的末端。
            m -= 1
        else:
            nums1[m+n-1] = nums2[n-1]
            n -= 1
        if n > 0:                       # 关键是这里：nums2指针没有扫完数组，需要把剩余部分，也就是最小的有序部分，拼接到nums1前面
            nums1[:n] = nums2[:n]       # 也就是nums2有比nums1更小的元素端，位置在n。
        return nums1


ex = [1, 2, 3, 0, 0, 0]
m = 3
ex2 = [4, 5, 6]
n = 3
print(merge(ex, m, ex2, n))

