package com.zhk.greedy;

//leetcode 860
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
                continue;
            }
            if (bills[i] == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
                continue;
            }
            //its 20
            if (ten > 0) {
                if (five > 0) {
                    five--;
                    ten--;
                    continue;
                }
                return false;
            }
            if (five < 3) {
                return false;
            }
            five -= 3;
        }
        return true;
    }
}
