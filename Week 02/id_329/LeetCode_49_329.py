# coding=utf-8

"""
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-anagrams
"""
import collections
from typing import List


class Solution:
    # 方法一：
    #       用排序的字符串作为同一组字母异位词的key,
    #       每个字符串都排序来判断是否属于key值，list做value
    # N为str数量，K为_str最大长度
    # 时间复杂度：O(NKlogK)，外循环O(N) + 内循环字符串排序O(KlogK)
    # 空间复杂度：O(NK)
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = collections.defaultdict(list)
        for _str in strs:
            # 这里tuple不可变，可以作为key
            # 第一个想到的应该是string
            result[tuple(sorted(_str))].append(_str)
        return list(result.values())

    # 方法二：
    #       以每个字母的计数组成的结构作为key
    # 时间复杂度：O(NK)，外循环O(N) + 内循环字符串遍历O(K)
    # 空间复杂度：O(NK)
    def groupAnagrams2(self, strs: List[str]) -> List[List[str]]:
        result = collections.defaultdict(list)
        for _str in strs:
            alpha_count = [0] * 26
            for _s in _str:
                alpha_count[ord(_s) - ord('a')] += 1
            result[tuple(alpha_count)].append(_str)
        return list(result.values())
