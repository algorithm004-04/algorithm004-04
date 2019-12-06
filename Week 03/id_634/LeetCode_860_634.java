class Solution {
    //1.贪心
    public boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0;
        if (bills.length < 1) return true;
        if (bills[0] != 5) return false;
        for (int i = 0; i < bills.length; ++i) {
            switch(bills[i])
            {
                case 5:
                    fives++;
                    break;
                case 10:
                    if (fives < 1) {
                        return false;
                    }
                    fives--;
                    tens++;
                    break;
                default:
                    if (tens > 0 && fives > 0) {
                        tens--;
                        fives--;
                    } else if (fives > 2) {
                        fives -= 3;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}