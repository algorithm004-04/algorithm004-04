# 20191102

# Done

"""
    二分查找法
"""
class Solution:
    def mySqrt(self, x: int) -> int:
        if x == 0 or x == 1:
            return x
        left, right = 1, x
        while left <= right:
            mid = left + (right - left) // 2
            print("mid: {}, mid^2: {}".format(mid, mid**2))
            if mid ** 2 == x:
                return mid
            if mid ** 2 < x:
                left = mid + 1
            else:
                right = mid - 1
        return right

"""
    牛顿迭代法
"""

class Solution:

    def mySqrt(self, x):
        if x < 0:
            raise Exception('不能输入负数')
        if x == 0:
            return 0
        # 起始的时候在 1 ，这可以比较随意设置
        cur = 1
        while True:
            pre = cur
            cur = (cur + x / cur) / 2
            if abs(cur - pre) < 1e-6:
                return int(cur)

"""
    牛顿迭代法：简洁写法（将除法改为整除）
"""
class Solution:

    def mySqrt(self, x):
        r = x
        while r*r > x:
            r = (r + x//r) // 2
        return r
s = Solution()
print(s.mySqrt(8))
print(s.mySqrt(9))
print(s.mySqrt(16))