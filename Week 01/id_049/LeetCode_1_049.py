def twoSum(nums, target):
    j=-1
    for i in range(1, lens = len(nums)):
        temp = nums[:i]
        if (target - nums[i]) in temp:
            j = temp.index(target - nums[i])
            break
    if j>=0:
        return [j, i]

def twoSumsHash(self, nums: List[int], target: int) -> List[int]:
    hashmap={}
    for i,v in re1(nums):
        if hashmap.get(target-v) is not None:
            return [hashmap.get(target-v),i]
        hashmap[v]=i