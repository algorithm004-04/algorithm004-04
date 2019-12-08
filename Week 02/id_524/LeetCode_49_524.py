#!/usr/bin/env python
#-*-coding:utf-8-*-
# author:lwz

'''
一、遍历数组，每个字符串排序后的值作为key，原字符串作为value放入字典中
    再遍历字典转化为列表

二、上面的算法简化一步：字典转列表的过程可以简化，省去一个循环



'''

nums = ["eat", "tea", "tan", "ate", "nat", "bat"]


def groupAnagrams(nums):
    result = []
    dicts = {}
    for i in nums:
        key = tuple(sorted(i))
        if key in dicts:
            dicts[key].append(i)
        else:
            dicts[key] = [i]

    for i in dicts:
        result.append(dicts[i])

    return result

def groupAnagrams2(nums):
    dicts = {}
    for i in nums:
        key = tuple(sorted(i))
        if key in dicts:
            dicts[key].append(i)
        else:
            dicts[key] = [i]

    return list(dicts.values())

print(groupAnagrams(nums))