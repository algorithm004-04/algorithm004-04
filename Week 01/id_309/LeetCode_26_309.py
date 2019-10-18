from __future__ import annotations


nums = [0,0,1,1,1,2,2,3,3]

class Solution1:
    def removeDuplicates(self, nums: List[int]) -> int:
        lenth = len(nums)
        for x in range(lenth):
            if x >= ( lenth - 1 ):
                break
            while x < ( lenth - 1 ) and nums[x] == nums[x+1]:
                nums.remove(nums[x])
                lenth -= 1
        return lenth

class Solution2:
    def removeDuplicates(self, nums: List[int]) -> int:
        lenth = len(nums)
        x = 0
        while x < ( lenth - 1 ):
            if nums[x] == nums[x+1]:
                nums.remove(nums[x])
                lenth -= 1
            else:
                x += 1
        return lenth

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        lenth = len(nums)
        i = 0
        x = 0
        while x < ( lenth - 1 ):
            if nums[x] == nums[x+1]:
                x += 1
            else:
                i += 1
                nums[i] = nums[x+1]
                x += 1
        return i + 1

if __name__ == "__main__":
    a = Solution().removeDuplicates(nums)
    print(a)
    print(nums)

