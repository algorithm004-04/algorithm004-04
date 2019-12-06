# 20191102

# Done

"""
贪心算法
"""
class Solution:
    def canJump(self, nums):
        mx = 0
        for i in range(len(nums)):
            print("i:{}, mx:{}".format(i ,mx))
            if i > mx:      # 如果当前位置比最大能走距离大则无法走到最后一个位置
                return False
            mx = max(nums[i] + i, mx)
        return mx > len(nums) - 1


s = Solution()
print(s.canJump([3,2,1,0,4]))