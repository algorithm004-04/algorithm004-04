class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        f = t = 0
        for i in bills:
            if i == 5:
                f += 1
            elif i == 10:
                f = f - 1
                t = t + 1
            elif t > 0:
                f = f - 1
                t = t - 1
            else:
                f -= 3
            if f < 0:
                return False
        return True
