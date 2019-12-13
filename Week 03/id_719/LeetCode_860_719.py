class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        five = ten = 0
        for i in bills:
            if i == 5:
                five += 1
            elif i == 10 and five:
                five, ten = five - 1, ten + 1
            elif i == 20 and five and ten:
                five, ten = five - 1, ten - 1
            elif i == 20 and five >= 3:
                five -= 3
            else:
                return False
        return True

    def lemonadeChange2(self, bills):
        five = ten = 0
        for i in bills:
            if i == 5:
                five += 1
            elif i == 10:
                five, ten = five - 1, ten + 1
            elif ten > 0:
                five, ten = five - 1, ten - 1
            else:
                five -= 3
            if five < 0:
                return False
        return True