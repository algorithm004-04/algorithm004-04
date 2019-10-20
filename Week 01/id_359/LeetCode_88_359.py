class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """
        # shift to right
        j = m + n
        for i in reversed(range(m)):
            # j points to the first letter of nums1 at last
            j -= 1
            nums1[j] = nums1[i]
            
        k, index = 0, 0
        # time O(2m + n)
        while (j < (m + n) and k < n):
            if (nums1[j] < nums2[k]):
                nums1[index] = nums1[j]
                j += 1
            else:
                nums1[index] = nums2[k]
                k += 1
            index += 1
        while j < m + n:
            nums1[index] = nums1[j]
            j += 1
            index += 1
        while k < n:
            nums1[index] = nums2[k]
            k += 1
            index += 1
