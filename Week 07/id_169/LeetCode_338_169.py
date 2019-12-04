from typing import List


class Solution:
    def countBits(self, num: int) -> List[int]:
        result = [0] * (num + 1)
        while num >= 0:
            if result[num] == 0:
                current, counters = num, []
                while current > 0:
                    counters.append(current)
                    for counter in counters:
                        result[counter] += 1
                    current &= current - 1
                for counter in counters:
                    if counter & 1 == 1 and counter - 1 > 0:
                        result[counter - 1] = result[counter] - 1
            num -= 1
        return result

    def dp(self, num: int) -> List[int]:
        result = [0] * (num + 1)
        a, b = 0, 1
        while b <= num:
            while a < b and a + b <= num:
                result[a + b] = result[a] + 1
                a += 1
            a = 0
            b <<= 1
        return result


print(Solution().countBits(3))
