# 20191103

# Done

"""
    创建一个字典，5元存入，10元判断五元个数，20元判断10元与5元个数或5元个数
"""
class Solution:
    def lemonadeChange(self, bills):
        money_dict = {5:0, 10:0, 20:0}
        for bill in bills:
            if bill == 5:
                money_dict[5] += 1
            elif bill == 10:
                money_dict[10] += 1
                if money_dict[5] >= 1:
                    money_dict[5] -= 1
                else:
                    return False
            else:
                money_dict[20] += 1
                if money_dict[10] >= 1 and money_dict[5] >= 1:
                    money_dict[10] -= 1
                    money_dict[5] -= 1
                elif money_dict[5] >= 3:
                    money_dict[5] -= 3
                else:
                    return False
        return True