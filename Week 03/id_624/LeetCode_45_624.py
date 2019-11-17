#
# @lc app=leetcode.cn id=45 lang=python3
#
# [45] 跳跃游戏 II
#
# https://leetcode-cn.com/problems/jump-game-ii/description/
#
# algorithms
# Hard (31.46%)
# Likes:    279
# Dislikes: 0
# Total Accepted:    20.7K
# Total Submissions: 65.3K
# Testcase Example:  '[2,3,1,1,4]'
#
# 给定一个非负整数数组，你最初位于数组的第一个位置。
# 
# 数组中的每个元素代表你在该位置可以跳跃的最大长度。
# 
# 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
# 
# 示例:
# 
# 输入: [2,3,1,1,4]
# 输出: 2
# 解释: 跳到最后一个位置的最小跳跃数是 2。
# 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
# 
# 
# 说明:
# 
# 假设你总是可以到达数组的最后一个位置。
# 
#

# @lc code=start

class Solution:
    # 只要当前位置没有到达末尾就执行：
    #   找到下一步可走的范围内能到达最远的那个位置。如果在寻找过程中已经到达末尾则返回，否则更新位置到这个最优选择
    def jump(self, nums: [int]) -> bool:
        count, p, end = 0, 0, len(nums)
        while p < end - 1:
            t, m, count = 0, 0, count + 1
            for i in range(p+1, p+nums[p]+1):
                if i == end-1: return count
                if nums[i] + i >= m: t, m = i, nums[i] + i
            p = t
        return count

# @lc code=end

