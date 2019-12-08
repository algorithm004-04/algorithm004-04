# 20191103

# Done
class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        if num == 0 or num == 1:
            return True
        left = 1
        right = num
        while left < right:
            mid = left + (right - left) // 2
            # print("left: {}, right: {}, mid: {}".format(left, right, mid))
            if mid ** 2 == num:
                return True
            if mid ** 2 > num:
                right = mid - 1
            else:
                left = mid + 1
        if right ** 2 == num:
            return True
        return False



s = Solution()
print(s.isPerfectSquare(16))
print(s.isPerfectSquare(8))
print(s.isPerfectSquare(14))
print(s.isPerfectSquare(9))
print(s.isPerfectSquare(104976))
print(104976 ** 0.5)