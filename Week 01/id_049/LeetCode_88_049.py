class Solution:
    #1使用额外空间
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        nums1_copy = nums1[:m]
        nums1[:]=[]
        i=j=0
        while i < m and j < n:
            if nums1_copy[i]<nums2[j]:
                nums1.append(nums1_copy[i])
                i+=1
            else:
                nums1.append(nums2[j])
                j+=1
        if i < m:
            nums1[i+j:]=nums1_copy[i:]
        if j < n:
            nums1[i+j:]=nums2[j:]
        return nums1

    #2不使用额外空间
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        while m>0 and n>0:
            if nums1[m-1]<=nums2[n-1]:
                nums1[m+n-1]=nums1[m-1]
                m-=1
            else:
                nums1[m+n-1]=nums2[n-1]
                n-=1
        if n>0:
            nums1[n:]=nums2[n:]