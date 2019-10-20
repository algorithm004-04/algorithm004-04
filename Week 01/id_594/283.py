def moveZeroes(nums):
    j = 0
    for i in range(len(nums)):
        if nums[i] != 0:
            nums[j] = nums[i]
            if j != i:
                nums[i] = 0
            j += 1
    return nums


def moveZeroes2(nums):
    zero = 0  # records the position of "0"
    for i in range(len(nums)):
        if nums[i] != 0:
            nums[i], nums[zero] = nums[zero], nums[i]
            zero += 1
    return nums


def moveZeroes3(nums):
    j = 0
    for i in range(len(nums)):
        if nums[i] != 0:
            nums[j] = nums[i]
            j += 1

    for n in range(j, len(nums)):
        nums[n] = 0
    return nums


test_arrry = [1, 0, 3, 5]

print(moveZeroes3(test_arrry))
