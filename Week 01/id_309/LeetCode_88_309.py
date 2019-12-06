from __future__ import annotations
import pysnooper

class Solution1:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        j = 1
        for i in nums2:
            nums1[-j] = i
            j += 1
        nums1[:] = sorted(nums1)
        # nums1[:] = sorted(nums1[:m] + nums2)

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        if n == 0:
            return None
        pz = len(nums1) - 1
        p1 = m - 1
        p2 = n - 1
        while pz >=0 and p2 >= 0:
            if p1 < 0 or nums2[p2] >= nums1[p1]:
                nums1[pz] =  nums2[p2]
                pz -= 1
                p2 -= 1
            elif nums1[p1] > nums2[p2]:
                nums1[pz] = nums1[p1]
                pz -= 1
                p1 -= 1

if __name__ == "__main__":
    nums1 = [7,2,3,0,0,0]
    nums2 = [5,1,6]
    m = 3
    n = 3
    Solution().merge(nums1, m, nums2, n)
    print(nums1)
