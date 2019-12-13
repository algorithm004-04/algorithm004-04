'''
387. 字符串中的第一个唯一字符
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:
s = "leetcode"
返回 0.
s = "loveleetcode",
返回 2.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
'''
'''
class Solution:
    def firstUniqChar(self, s):
        if len(s) == 0:
            return -1
        if len(s) == 1:
            return 0
        # find: 从左向右查找
        # rfind：从右向左查找
        for ch in s:
            if s.find(ch) == s.rfind(ch):
                return s.find(ch)
        return -1
'''

'''
哈希

import collections
class Solution:
    def firstUniqChar(self, s):
        count = collections.Counter(s)
        index = 0
        for ch in s:
            if count[ch] == 1:
                return index
            else:
                index += 1
        return -1

import collections
class Solution:
    def firstUniqChar(self, s):
        return min([s.find(c) for c, v in collections.Counter(s).items() if v == 1] or [-1])
'''
'''

import string
class Solution:
    def firstUniqChar(self, s):
        index = [s.index(ch) for ch in string.ascii_lowercase if s.count(ch) == 1]
        return min(index) if len(index) > 0 else -1

import string
class Solution:
    def firstUniqChar(self, s):
        return min([s.find(ch) for ch in string.ascii_lowercase if s.count(ch) == 1] or [-1])
'''

'''

class Solution:
    def firstUniqChar(self, s):
        d = {}
        seen = set()
        for index, ch in enumerate(s):
            if ch not in seen:
                d[ch] = index
                seen.add(ch)
            else:
                del d[ch]
        return min(d.values()) if d else -1

class Solution:
    def firstUniqChar(self, s):

        for i in range(len(s)):
            ch = s[i]
            if s.count(ch) == 1:
                return i
        return -1

import collections
class Solution:
    def firstUniqChar(self, s):

        for i in range(len(s)):
            ch = s[i]
            if collections.Counter(s).get(ch, 0) == 1:
                return i
        return -1
'''
class Solution:
    def firstUniqChar(self, s):
        dic = {}

        for ch in s:
            if ch in dic.keys():
                dic[ch] += 1
            else:
                dic[ch] = 1

        for i in range(len(s)):
            c = s[i]
            if dic[c] == 1:
                return i
        return -1


s = 'loveleetchode'
tmp = Solution()
print(tmp.firstUniqChar(s))