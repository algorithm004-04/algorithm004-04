def removeDuplicates(nums):
    j = 1
    for i in range(1, len(nums)):
        if nums[i] == nums[i-1]:
            nums[j] = nums[i]
            j += 1
    return j, nums[j], nums


ex = [1, 2, 2, 3]
print(removeDuplicates(ex))

