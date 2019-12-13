public class LeetCode_860_034 {

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five ++;
            } else if (bill == 10) {
                five --;
                ten ++;
            } else if (ten > 0) {
                five --;
                ten --;
            } else {
                five -= 3;
            }

            if (five < 0) {
                return false;
            }
        }

        return true;
    }
}
