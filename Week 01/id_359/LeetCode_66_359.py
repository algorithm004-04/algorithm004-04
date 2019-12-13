class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        inc, i = 1, len(digits) - 1
        while i >= 0:
            if digits[i] == 9:
                digits[i] = 0
            else:
                digits[i] += 1
                inc = 0
                break
            i -= 1
        # 100000000...
        if inc == 1:
            digits.insert(0, 1)
        return digits
            
