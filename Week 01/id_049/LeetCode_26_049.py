# 由于已经排序完毕，所以和自己后边的比如果不同就是一个新的数字，移动到后边
class Solution:
# 执行用时 :100 ms, 在所有 python3 提交中击败了91.75%的用户
# 内存消耗 :15.2 MB, 在所有 python3 提交中击败了5.25%的用户
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums: return 0
        i = 0
        for j in range(len(nums)):
            if nums[j] != nums[i]:
                i+=1
                nums[i]=nums[j]
        return i+1