class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap={}
        for ind,num in enumerate(nums):
            if hashmap.get(target-num) is not None:
                return [ind,hashmap.get(target-num)]
            hashmap[num]=ind

        return[]