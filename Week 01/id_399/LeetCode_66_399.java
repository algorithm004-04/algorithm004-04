class Solution {
    public int[] plusOne(int[] digits) {
    	int k = 1;
    	int length = digits.length;
		for (int i = length - 1; i >= 0; i--) {
    		int j = digits[i] + k;
			if (j > 9) {
    			digits[i] = j - 10;
    			if (i == 0) {
					int[] array = new int [length + 1];
					array[0] = 1;
					System.arraycopy(digits, 0, array, 1, length);
					digits = array;
				}
    			k = 1;
			}else {
				digits[i] = j;
				k = 0;
			}
		}
		return digits;
    }
}