public class Leetcode_283_704 {

    public int[] plusOne(int[] digits) {

        if(digits[digits.length-1] != 9){
            digits[digits.length-1] = digits[digits.length-1] + 1;
            return digits;
        }else {

            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] == 9){
                    digits[i] = 0;
                }else {
                    digits[i] = digits[i] + 1;
                    break;
                }
                if (i == 0){
                    digits = new int[digits.length + 1];
                    digits[0] = 1;
                }

            }
        }

        return digits;
    }
}