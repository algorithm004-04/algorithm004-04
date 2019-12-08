#! /usr/bin/env python
# coding=utf-8


class Solution(object):

    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return n and (n - (n & -n)) == 0


if __name__ == '__main__':
    sol = Solution()
    assert sol.isPowerOfTwo(8) is True
    assert sol.isPowerOfTwo(13) is not True
    assert sol.isPowerOfTwo(88) is not True
