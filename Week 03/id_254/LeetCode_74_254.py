class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        L = len(matrix)
        if L == 0 or len(matrix[0]) == 0:
            return False
        l, r = 0, L-1
        while l <= r:
            mid = (l+r) >> 1
            curr_arr = matrix[mid]
            arr_l = len(curr_arr)
            if curr_arr[0] <= target <= curr_arr[arr_l-1]:
                l, r = 0, arr_l-1
                while l <= r:
                    mid = (l+r) >> 1
                    if curr_arr[mid] == target:
                        return True
                    elif curr_arr[mid] < target:
                        l = mid+1
                    else:
                        r = mid-1
                return False

            elif curr_arr[0] > target:
                r = mid - 1
            elif curr_arr[arr_l-1] < target:
                l = mid + 1
        return False
