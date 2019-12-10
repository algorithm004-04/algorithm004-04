def twoSum(nums, target):
    dct = {}
    for i, n in enumerate(nums):
        if target - n in dct:
            return [dct[target-n], i]
        dct[n] = i


nums = [2, 7, 11, 15]
target = 9
a = twoSum(nums, target)