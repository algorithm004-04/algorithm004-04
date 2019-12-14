class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        results = []
        for p in range(len(nums)-2):
            if p>0 and nums[p] == nums[p-1]:
                continue
            l, r = p+1, len(nums)-1
            while l < r:
                s = nums[p] + nums[l] + nums[r]
                if s > 0:
                    r -= 1
                elif s < 0:
                    l += 1
                else:
                    results.append([nums[p],nums[l],nums[r]])
                    while l < r and nums[l] == nums[l+1]:
                        l += 1
                    while r > l and nums[r] == nums[r-1]:
                        r -= 1
                    r-=1
                    l+=1
        return results