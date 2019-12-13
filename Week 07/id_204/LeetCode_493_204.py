class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        def helper(nums,l,r):
            if r == l:
                return 0
            m = l + 1 + (r-l)//2
            L = helper(nums,l,m-1)
            R = helper(nums,m,r)

            i = l
            j = m
            ans = L + R
            while i < m and j <= r:
                if nums[i] > 2*nums[j]:
                    ans += m - i
                    j += 1
                else:
                    i += 1
            #通过两路归并排序nums[l:r+1]
            temp = []
            i = l
            j = m
            while i < m and j <= r:
                if nums[i] < nums[j]:
                    temp.append(nums[i])
                    i += 1
                else:
                    temp.append(nums[j])
                    j += 1
            if i == m:
                while j <= r:
                    temp.append(nums[j])
                    j += 1
            else:
                while i < m:
                    temp.append(nums[i])
                    i += 1
            nums[l:r+1] = temp
            return ans
        if not nums:
            return 0
        else:
            return helper(nums,0,len(nums)-1)

