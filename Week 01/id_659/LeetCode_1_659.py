#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap={}
        for i,num in enumerate(nums):
            if hashmap.get(target - num) is not None:
                return [i,hashmap.get(target - num)]
            hashmap[num] = i


            
            
            
        
# @lc code=end

