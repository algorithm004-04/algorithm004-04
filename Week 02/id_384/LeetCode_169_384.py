#1.哈希表法：
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        a = set(nums)
        for i in a:
            if nums.count(i) > len(nums) / 2:
                return i

class Solution:
def majorityElement(self, nums):
        counts = collections.Counter(nums)
        return max(counts.keys(), key=counts.get)

#2.排序法：
#如果所有数字被单调递增或者单调递减的顺序排了序，那么众数的下标为n / 2(当n为偶数时，下标为n / 2 + 1)
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        nums.sort()
        return nums[len(nums) // 2]

#3.摩尔投票法：
#类似于开心消消乐，遍历整个数组，先选举一个数为众数，只要后面的数跟他相同就加一，不同就减一，如果为0了，就忘记所有遍历过的元素，重新选举一个众数
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        p = nums[0]
        count = 0
        for e in nums:
            p = e if not count else p
            if e == p:
                count += 1
            else: 
                count -= 1
        return p
