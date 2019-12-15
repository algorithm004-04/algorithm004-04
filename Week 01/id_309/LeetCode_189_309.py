from __future__ import annotations

class Solution1:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        x = 0
        lenth = len(nums)
        while x < k:
            tmp = nums[-1]
            x += 1
            i = 1
            while i < lenth:
                nums[-i] = nums[-i-1]
                i += 1
            nums[0] = tmp

class Solution2:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        import collections
        a = collections.deque(nums)
        a.rotate(k)
        nums[:] = list(a)

class Solution3:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k % n
        nums[:] = nums[n-k:] + nums[:n-k]

class Solution:
    @pysnooper.snoop()
    def rotate(self, nums: List[int], k: int) -> None:
        lenth = len(nums)
        k = k % lenth
        if lenth <= 1 or k <= 0:
            return None
        first = 0
        middle = lenth - k
        last = lenth
        next = middle
        while first != next:
            nums[first],nums[next] = nums[next],nums[first]
            first += 1
            next += 1
            # 二号指针走k步，就碰到最后，就回到分界线，因为分界线分割了数组
            # 分界线右侧是一个循环替换。
            if next == last:
                next = middle
            # 如果一号指针碰到分界线，就把分界线改成二号指针的位置
            # 这个if-else就是把数组切分了。以13右移5举例：
            # 先排好了5+3=8，则分界线变动。数组切出来一个5右移2
            # 排好5右移2，还剩13-8-2=3
            # 继续排3右移2，排到最后，二号指针和一号指针相遇。
            elif first == middle:
                middle = next

if __name__ == "__main__":
    nums = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21]
    k = 29
    Solution().rotate(nums, k)
    print(nums)
