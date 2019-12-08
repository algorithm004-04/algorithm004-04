class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if not n: return False
        n = n & (n - 1)
        return not n
