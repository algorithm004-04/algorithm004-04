def twoSum(self, nums: List[int], target: int) -> List[int]:
    hashmap = {}
    for i, v in enumerate(nums):
        if hashmap.get(target-v) is not None:
            return [hashmap.get(target-v), i]
        hashmap[v] = i
