def twoSumsHash(self, nums: List[int], target: int) -> List[int]:
    hashmap = {}
    for i, v in enumerate(nums):
        if hashmap.get(target-v) in hashmap:
            return [hashmap.get(target-v),i]
    hashmap[v]=i