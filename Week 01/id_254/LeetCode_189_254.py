# 1. 根据 K值 遍历数组 k次 每次移动一格
# class Solution:
#     def rotate(self, nums: List[int], k: int) -> None:
#         numLen = len(nums)
#         while (k%numLen) > 0 :
#             k=k-1
#             temp = nums[0]
#             for i in range(numLen) :
#                 if(i != numLen-1):
#                     temp,nums[i+1] = nums[i+1],temp
#                 else:
#                     nums[0] = temp

# 2. 获取需要平易的位数 k,将最后 k位赋予 数组前k上.将数组前k位向前移k位
# class Solution:
#     def rotate(self, nums: List[int], k: int) -> None:
#         k %= len(nums)
#         nums[:] = nums[-k:] + nums[:-k]


# 3. 循环替换法. 将当前元素移到下一个元素,再将下一个元素移到 它下一个元素.依次循环,直到 遇到开始那个元素,则从开始那个元素下一个元素开始.
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        k = k%len(nums)
        count = 0
        start = 0
        while count < len(nums):
            pre = nums[start]
            current = start
            new = 0
            while current != start or new == 0:
                next = (current+k)%len(nums)
                new = 1
                nums[next],pre = pre,nums[next]
                count = count+1
                current = next
            start = start+1  # 1. 根据 K值 遍历数组 k次 每次移动一格
# class Solution:
#     def rotate(self, nums: List[int], k: int) -> None:
#         numLen = len(nums)
#         while (k%numLen) > 0 :
#             k=k-1
#             temp = nums[0]
#             for i in range(numLen) :
#                 if(i != numLen-1):
#                     temp,nums[i+1] = nums[i+1],temp
#                 else:
#                     nums[0] = temp

# 2. 获取需要平易的位数 k,将最后 k位赋予 数组前k上.将数组前k位向前移k位
# class Solution:
#     def rotate(self, nums: List[int], k: int) -> None:
#         k %= len(nums)
#         nums[:] = nums[-k:] + nums[:-k]


# 3. 循环替换法. 将当前元素移到下一个元素,再将下一个元素移到 它下一个元素.依次循环,直到 遇到开始那个元素,则从开始那个元素下一个元素开始.
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        k = k % len(nums)
        count = 0
        start = 0
        while count < len(nums):
            pre = nums[start]
            current = start
            new = 0
            while current != start or new == 0:
                next = (current+k) % len(nums)
                new = 1
                nums[next], pre = pre, nums[next]
                count = count+1
                current = next
            start = start+1
