#!/usr/bin/env python
#-*-coding:utf-8-*-
# author:lwz

'''
一、暴力求解，两层循环。O(NlogN)
    左边界是i，在i固定的情况下，循环j来寻找右边界。右边界如何判定？如果找到一个比左边界高/相等 或 比左边界底、但遍历完之后的最高的那个值，就是右边界
    这样下来会记录所有的情况，但会有包含的情况。需要处理【在这里】
    关于计算面积，用 数组/栈 来记录从左边界到右边界之间的情况。积水面积 = 两个边界之间的面积 - 中间区域柱子本身的面积


二、优化
    1.maxRight只需记录下标即可，节省内存空间
    2.将去重的环节放在加入result前判断，节省了两层嵌套for循环
    3.可以将middle数组省去，节省内存空间
    4.当做完前三步后，可以将最后一个计算面积的循环也省去。

    提交结果：执行88ms，击败38.54%。   内存消耗14.4MB，击败5%

三、换一个思维
    遍历数组，计算每个元素头顶上的积水面积。这需要以数组为中心，寻找左右边界。

四、优化
    在遍历数组时，每次都要重复地找左右边界。可以提前先找好，将其存储在数组中。

'''

list = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]


def trap(list):
    result = []
    for i in range(len(list) - 1):
        maxRight = {"index": -1, "value": 0}
        middle = [] # 数组, 记录左右边界中间的值
        for j in range(i + 1, len(list)):
            maxRight = {"index": j,"value": list[j]} if maxRight["value"] <= list[j] else maxRight  # 这里注意，找最大值，同时记录最靠右的下标
            if list[i] <= list[j]:
                # 计算面积、加入result
                if len(middle) == 0: break # 如果没有中间值，表名此左边界没有有效的右边界
                item = 0
                for k in middle:
                    item += list[k] * 1
                area = (j - i - 1) * list[i] - item
                result.append({"left":i,"right":j,"area":area})
                break
            else:
                if j == len(list) - 1:
                    if len(middle) == 0: break
                    # 找最靠右、相对最高的：计算面积、加入result
                    item = 0
                    for k in range(i+1, maxRight["index"]):
                        item += list[k] * 1
                    area = (maxRight["index"] - i - 1) * maxRight["value"] - item
                    result.append({"left": i, "right": maxRight["index"], "area": area})

                middle.append(list[j])

    # 将被包含的结果删除
    for i in result:
        for j in result:
            if i["left"] <= j["left"] and i["right"] >= j["right"] and i != j:
                result.remove(j)

    area = 0
    for i in result:
        area += i["area"]

    return area


def trap1(list):
    result = [] # 数组，存储最终的解决方案
    finalArea = 0 # 最后的面积
    for i in range(len(list) - 1):
        maxRight = -1
        for j in range(i + 1, len(list)):
            maxRight = j if list[maxRight] <= list[j] else maxRight  # 找最大值,记录最靠右的下标
            if list[i] <= list[j]:
                # 计算面积、加入result
                if j - i == 1: break # 如果没有中间值，表明此左边界没有有效的右边界
                item = 0
                for k in range(i + 1, j):
                    item += list[k] * 1
                area = (j - i - 1) * list[i] - item
                if len(result) > 0:
                    if not (result[-1]["left"] <= i and result[-1]["right"] >= j):
                        finalArea += area
                        result.append({"left":i,"right":j})
                else:
                    finalArea += area
                    result.append({"left":i,"right":j})
                break
            else:
                if j == len(list) - 1:
                    if j - i == 1: break
                    # 找最靠右、相对最高的：计算面积、加入result
                    item = 0
                    for k in range(i + 1, maxRight):
                        item += list[k] * 1
                    area = (maxRight - i - 1) * list[maxRight] - item
                    if len(result) > 0:
                        if not (result[-1]["left"] <= i and result[-1]["right"] >= j):
                            finalArea += area
                            result.append({"left": i, "right": maxRight})
                    else:
                        finalArea += area
                        result.append({"left": i, "right": maxRight})

    return finalArea


def trap2(list):
    "遍历数组，对于每个元素来说，计算它头顶上的水的面积【第一个和最后一个头顶上永远没水】"
    ans = 0
    size = len(list)
    for i in range(1, size - 1):
        maxRight, maxLeft = 0, 0
        for j in range(i - 1, -1, -1):
            maxLeft = max(maxLeft, list[j])
        for j in range(i + 1, size):
            maxRight = max(maxRight, list[j])
        area = min(maxLeft, maxRight) - list[i]
        ans += area if area >= 0 else 0

    return ans


def trap3(list):
    "与前一种算法不同的是，我们不需要每次都将i的左右边界遍历出来，提前将它遍历出来"
    sum = 0
    maxLeft = [list[0], -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
    maxRight = [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, list[-1]]

    for i in range(1, len(list)):
        maxLeft[i] = max(maxLeft[i - 1], list[i - 1])

    for i in range(len(list)-2, -1, -1):
        maxRight[i] = max(maxRight[i + 1], list[i + 1])

    for i in range(1, len(list)-1):
        area = min(maxRight[i], maxLeft[i]) - list[i]
        sum += area if area >= 0 else 0

    return sum

result1 = trap2(list)
result = trap3(list)

print(result1)
print(result)


