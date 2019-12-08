class Solution(object):
    def reversePairs(self, nums):
        if not nums:
            return 0
        return self.merge_sort_count(nums, 0, len(nums)-1) #0-4

    def merge_sort_count(self, nums, begin, end):
        if begin == end:
            return 0
        mid = (end+begin) >> 1
        count = 0
        count += self.merge_sort_count(nums, begin, mid)#0-2
        count += self.merge_sort_count(nums, mid+1, end)#3-4

        i, j = begin, mid+1
        while i <= mid and j <= end:
            if nums[i] > nums[j]*2:
                count += mid+1-i
                j += 1
            else:
                i += 1
        nums[begin:end+1] = sorted(nums[begin:end+1])
        return count