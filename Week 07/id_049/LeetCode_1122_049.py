class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        res = []
        for i in arr2:
            while i in arr1:
                res.append(i)
                arr1.remove(i)
        return res+sorted(arr1)