def twoSum(nums: list, target: int):
    if len(nums) <= 0:
        return False

    _dict = {}

    for i in range(len(nums)):
        if nums[i] in _dict:
            return _dict[nums[i]], i
        else:
            _dict[target - nums[i]] = i


list = [3, 2, 4]
list2 = [3]
target = 6
print(twoSum(list, target))
