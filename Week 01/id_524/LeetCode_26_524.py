#!/usr/bin/env python
#-*-coding:utf-8-*-
# author:lwz


'''
一、利用字典（键值对）去重
    题目要求说不能使用额外的数组空间，因此我使用了额外的字典空间。
    字典天生具有去重的特性（集合set也是）

二、双指针法（快慢指针）
    这是个有序数组，说明所有的重复元素都是相邻的。
    两个指针i,j下标的初始状态为0,1，都向右移动。i在左边，表示去重之后的元素下标，j在右边，用来遍历数组中的每个元素。
    每次循环，都将i和j对应的元素比较是否相等，如果相等，i不动，j++。如果不等，将list[i+1] = list[j]，并i++,j++。
    当j等于数组长度时结束循环。



'''

def removeDuplicates(list):
    dict = {}
    for i in range(len(list)):
        dict[list[i]] = i
    for i, key in enumerate(dict):
        list[i] = key

    return len(dict)


def removeDuplicates2(list):
    i, j = 0, 1
    while j < len(list):
        if list[i] != list[j]:
            if i + 1 != j: # 如果i、j紧邻，没必要赋值操作
                list[i + 1] = list[j]
            i += 1
        j += 1 # 无论是否遇到重复值，都j++
    return i+1

def removeDuplicates3(list):
    i = 1
    for j in range(1, len(list)):
        if list[j] != list[j-1]:
            list[i] = list[j]
            i += 1

    return i



list = [0,0,1,1,1,2,2,3,3,4]

print(removeDuplicates2(list))
print(list)
