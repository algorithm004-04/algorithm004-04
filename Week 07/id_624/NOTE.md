# 排序算法

## 1.冒泡排序（Bubble Sort）

冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越大的元素会经由交换慢慢“浮”到数列的顶端。 

### 算法描述

* 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
* 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
* 针对所有的元素重复以上的步骤，除了最后一个；
* 重复步骤1~3，直到排序完成。

```
def bubbleSort(nums: [int]):
    for i in range(len(nums)-1):
        for j in range(len(nums)-i-1):
            if nums[j] > nums[j+1]: nums[j], nums[j+1] = nums[j+1], nums[j]
```
  
## 2. 择排序（Selection-sort）

选择排序是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。 

### 算法描述

n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：

* 初始状态：无序区为R[1..n]，有序区为空；
* 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
* n-1趟结束，数组有序化了。

```
def selectionSort(nums: [int]):
    for i in range(len(nums)-1):
        for j in range(i + 1, len(nums)):
            if nums[j] < nums[i]: nums[j], nums[i] = nums[i], nums[j]
```

## 3.插入排序（Insertion-Sort）

插入排序的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。

### 算法描述

* 从第一个元素开始，该元素可以认为已经被排序；
* 取出下一个元素，在已经排序的元素序列中从后向前扫描；
* 如果该元素（已排序）大于新元素，将该元素移到下一位置；
* 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
* 将新元素插入到该位置后；
* 重复步骤2~5。
```
def insertionSort(nums: [int]):
    for i in range(len(nums)-1):
        for j in range(i+1, 0, -1):
            if nums[j] < nums[j-1]: nums[j], nums[j-1] = nums[j-1], nums[j]
```

## 4.归并排序（Merge-Sort）

归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。 

### 算法描述

* 把长度为n的输入序列分成两个长度为n/2的子序列；
* 对这两个子序列分别采用归并排序；
* 将两个排序好的子序列合并成一个最终的排序序列。

```
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
```

## 5.快速排序（Quick-Sort）

快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。

### 算法描述

快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：

* 从数列中挑出一个元素，称为 “基准”（pivot）；
* 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
* 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。

```
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
```

## 6.堆排序（Heapsort）

堆排序是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。

### 算法描述

* 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
* 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
* 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。

```
def heapSort(nums: [int]):
    heap = []
    for n in nums: heappush(heap, n)
    for i in range(len(nums)): nums[i] = heappop(heap)
```

## 7.计数排序

计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。

### 算法描述

找出待排序的数组中最大和最小的元素；
统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。

```
def countSort(nums: [int]) -> [int]:
    counters, res = [0] * (max(nums) + 1), []
    for n in nums: counters[n] += 1
    for i in range(len(counters)):
        if counters[i] > 0: res += [i] * counters[i]
    return res
```