class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        maps = {}
        # time O(n) space O(n)
        for i in range(len(nums)):
            if nums[i] in maps:
                # more than one same number
                maps[nums[i]].append(i)
            else:
                maps[nums[i]] = [i]
        for i in range(len(nums)):
            a, b = nums[i], target - nums[i]
            if a in maps and b in maps:
                if a != b:
                    return maps[a][0], maps[b][0]
                elif len(maps[a]) > 1:
                    return maps[a][0], maps[a][1]
