class Solution1:
    def plusOne(self, digits: List[int]) -> List[int]:
        digits = "".join(map(lambda x:str(x), digits))
        digits = int(digits) + 1
        digits = list(str(digits))
        return digits
    
class Solution2:
    def plusOne(self, digits: List[int]) -> List[int]:
        digits = "".join(str(x) for x in digits)
        digits = int(digits) + 1
        digits = list(str(digits))
        return digits

class Solution3:
    def plusOne(self, digits: List[int]) -> List[int]:
        result = []
        digits = "".join(str(x) for x in digits)
        digits = str(int(digits) + 1)
        for i in digits:
            result.append(i)
        return result
    
class Solution4:
    def plusOne(self, digits: List[int]) -> List[int]:
        lenth = len(digits)
        if digits[-1] != 9:
            digits[-1] += 1
            return digits
        elif len(set(digits)) > 1 and digits[-1] == 9:
            i = -1
            j = 0
            while digits[i] == 9:
                digits[i] = 0
                i = i - 1
                j += 1
            digits[-j-1] += 1
            return digits
        elif len(set(digits)) == 1 and list(set(digits))[0] == 9:
            result = []
            result = [0] * lenth
            result.insert(0, 1)
            return result

class Solution5:
    def plusOne(self, digits: List[int]) -> List[int]:
        if len(digits) == 1 and digits[0] == 9:
            return [1, 0]
        if digits[-1] != 9:
            digits[-1] += 1
            return digits
        else:
            digits[-1] = 0
            digits[:-1] = self.plusOne(digits[:-1])
            return digits

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        for i in range(len(digits)):
            if digits[~i] < 9:
                digits[~i] += 1
                return digits
            elif digits[~i] == 9:
                digits[~i] = 0
        return [1] + [0] * len(digits)
