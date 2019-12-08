class Solution(object):
    def twoSum(self, nums, target):
        res = {}
        for i in xrange(len(nums)):
            n = nums[i]
            if n in res: #[1]
                return [res[n], i]
            else:
                res[target-n] = i #[0]
        return []