class Solution(object):

    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        arr = [0] * 26
        for _, c in enumerate(s):
            arr[ord(c) - ord('a')] += 1
        for i, c in enumerate(s):
            if arr[ord(c) - ord('a')] == 1:
                return i
        return -1