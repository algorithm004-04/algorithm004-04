from heapq import heappop
from heapq import heappush

def bubbleSort(nums: [int]):
    for i in range(len(nums)-1):
        for j in range(len(nums)-i-1):
            if nums[j] > nums[j+1]: nums[j], nums[j+1] = nums[j+1], nums[j]

def selectionSort(nums: [int]):
    for i in range(len(nums)-1):
        for j in range(i + 1, len(nums)):
            if nums[j] < nums[i]: nums[j], nums[i] = nums[i], nums[j]

def insertionSort(nums: [int]):
    for i in range(len(nums)-1):
        for j in range(i+1, 0, -1):
            if nums[j] < nums[j-1]: nums[j], nums[j-1] = nums[j-1], nums[j]

def mergeSort(nums: [int], l, r):
    if l >= r: return
    mid = l + (r - l) // 2
    mergeSort(nums, l, mid)
    mergeSort(nums, mid + 1, r)

    # merge
    i, j, temp = l, mid+1, []
    while i <= mid and j <= r:
        if nums[i] <= nums[j]: temp.append(nums[i]); i += 1
        else: temp.append(nums[j]); j += 1
    if i <= mid: temp += nums[i:mid+1]
    if j <= r: temp += nums[j:r+1]
    nums[l:r+1] = temp

def quickSort(nums: [int], l, r):
    def partition(l, r) -> int:
        pivot, counter = r, l
        for i in range(l, r):
            if nums[i] < nums[pivot]:
                nums[counter], nums[i] = nums[i], nums[counter]
                counter += 1
        nums[pivot], nums[counter] = nums[counter], nums[pivot]
        return counter

    if l >= r: return
    pivot = partition(l, r)
    quickSort(nums, l, pivot - 1)
    quickSort(nums, pivot + 1, r)

    
def heapSort(nums: [int]):
    heap = []
    for n in nums: heappush(heap, n)
    for i in range(len(nums)): nums[i] = heappop(heap)

def countSort(nums: [int]) -> [int]:
    counters, res = [0] * (max(nums) + 1), []
    for n in nums: counters[n] += 1
    for i in range(len(counters)):
        if counters[i] > 0: res += [i] * counters[i]
    return res

nums = [4, 3, 5, 8 ,1, 2, 9, 6]
# insertionSort(nums)
# quickSort(nums, 0, len(nums)-1)
# heapSort(nums)
nums = countSort(nums)
print(nums)