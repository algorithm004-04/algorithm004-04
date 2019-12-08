class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        return [j for j in str(int(''.join([str(i) for i in digits])) + 1)]
