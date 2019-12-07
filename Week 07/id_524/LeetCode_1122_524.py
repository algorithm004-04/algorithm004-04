#!/usr/bin/env python
#-*-coding:utf-8-*-
# author:lwz
import collections

class Solution(object):

    def relativeSortArray(self, A, B):
        k = {b: i for i, b in enumerate(B)}
        return sorted(A, key=lambda a: k.get(a, 1000 + a))

    def relativeSortArray2(self, arr1, arr2):
        ans, cnt = [], collections.Counter(arr1)
        for i in arr2:
            if cnt[i]: ans.extend([i] * cnt.pop(i))
        for i in range(1001):
            if cnt[i]: ans.extend([i] * cnt.pop(i))
        return ans


