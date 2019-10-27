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
            nums[i], nums[zero] = nums[zero], nums[i]     # 这个地方明显有毒，和下面的方式是不对等的
            # nums[i] = nums[zero]
            # nums[zero] = nums[i]
            print(" nums[i]:", nums[i], '\n', "nums[zero]:", nums[zero])
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


test_arrry = [0, 1, 0, 3, 12]
print(moveZeroes2(test_arrry))
