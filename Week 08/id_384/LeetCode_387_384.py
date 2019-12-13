class Solution:
    def firstUniqChar(self, s: str) -> int:
        from collections import Counter
        a = Counter(s)
        index = 0
        for i in s:
            if a[i] == 1:
                return index
            else:
                index += 1
        return -1
