class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        count =0
        temp =None
        for i in nums: 
            if count==0:
                temp =i
            count +=(1 if i==temp else -1 )
        return temp
            