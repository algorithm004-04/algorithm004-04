class Solution {
    public int[] plusOne(int[] digits) {
          int length = digits.length;
    if (digits[length - 1] != 9) {
        digits[length - 1] = digits[length - 1] + 1;
        return digits;
    }
    digits[length - 1] = 0;
    for (int i = length - 2; i >= 0; i --) {
        if (digits[i] == 9) {
            digits[i] = 0;
        } else {
            digits[i] = digits[i] + 1;
            break;
        }
    }

    if (digits[0] == 0) {
        digits = Arrays.copyOf(digits, length + 1);
        digits[0] = 1;
    }

    return digits;
    }
}