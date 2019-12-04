from typing import List
class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        arr = [0 for _ in range(1001)]  # 由于题目说arr1的范围在0-1000，所以生成一个1001大小的数组用来存放每个数出现的次数。
        ans = []  # 储存答案的数组。
        for i in range(len(arr1)):  # 遍历arr1，把整个arr1的数的出现次数储存在arr上，arr的下标对应arr1的值，arr的值对应arr1中值出现的次数。
            arr[arr1[i]] += 1  # 如果遇到了这个数，就把和它值一样的下标位置上+1，表示这个数在这个下标i上出现了1次。
        for i in range(len(arr2)):  # 遍历arr2，现在开始要输出答案了。
            while arr[arr2[i]] > 0:  # 如果arr2的值在arr所对应的下标位置出现次数大于0，那么就说明arr中的这个位置存在值。
                ans.append(arr2[i])  # 如果存在值，那就把它加到ans中，因为要按arr2的顺序排序。
                arr[arr2[i]] -= 1  # 加进去了次数 -1 ，不然就死循环了。
        for i in range(len(arr)):  # 如果arr1的值不在arr2中，那么不能就这么结束了，因为题目说了如果不在，剩下的值按照升序排序。
            while arr[i] > 0:  # 同样也是找到大于0的下标，然后一直加到ans中，直到次数为0。
                ans.append(i)
                arr[i] -= 1
        return ans  # 返回最终答案。


if __name__ == "__main__":
    solution = Solution()
    print(solution.relativeSortArray(arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]))