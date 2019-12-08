#!/usr/bin/env python
#-*-coding:utf-8-*-
# author:lwz


def lemonadeChange(bills):
    ""
    five, ten = 0, 0
    for i in bills:
        if i == 5:
            five += 1
        elif i == 10:
            if five == 0: return False
            five -= 1
            ten += 1
        elif i == 20:
            if five > 0 and ten > 0:
                ten -= 1
                five -= 1
            elif five >= 3:
                five -= 3
            else:
                return False

    return True


