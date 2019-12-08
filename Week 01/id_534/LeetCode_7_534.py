class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        num = 0
        for i in reversed(range(len(digits))):
            num = num + digits[i] * 10**(len(digits) - i -1)
        nums = [int(i) for i in str(num + 1)]
        return nums
