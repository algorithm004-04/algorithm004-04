#!/usr/bin/env python
#-*-coding:utf-8-*-
# author:lwz

'''
一、暴力求解 O(n²)
    两层循环去寻找和为target

二、利用字典（键值对） O(n)
    内层循环每次都要寻找另一个数，非常耗时。可以将遍历过的数字以键值对存储起来，在查找的时候非常省时。

'''

def twoSum(list, target):
    result = []
    for i in range(len(list)):
        for j in range(i + 1, len(list)): # 从i + 1开始遍历，就杜绝了重复使用同一个元素的情况
            if list[i] + list[j] == target:
                result.append([i,j])

    return result


def twoSum2(list, target):
    result = []
    dict = {}
    for i in range(len(list)):
        num = target - list[i]
        if num in dict:
            result.append([dict[num], i])
        dict[list[i]] = i

    return result




list = [2,7,11,15,2]
print(twoSum2(list,9))