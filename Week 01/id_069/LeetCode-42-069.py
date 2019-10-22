#给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
#
# 
#
# 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。 
#
# 示例: 
#
# 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
#输出: 6 
# Related Topics 栈 数组 双指针



#leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def trap(self, height):
        left = 0
        right = len(height) - 1
        ans = 0
        left_max, right_max = 0, 0
        while left < right:
            if height[left] < height[right]:
                if height[left] >= left_max:
                    left_max = height[left]
                else:
                    ans += (left_max - height[left])
                left += 1
            else:
                if height[right] >= right_max:
                    right_max = height[right]
                else:
                    ans += (right_max - height[right])
                right -= 1
        return ans

        
#leetcode submit region end(Prohibit modification and deletion)

s = Solution()
print(s.trap([0,1,0,2,1,0,1,3,2,1,2,1]))