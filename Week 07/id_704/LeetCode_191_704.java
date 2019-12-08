public class Solution {
    // you need to treat n as an unsigned value
    // public int hammingWeight(int n) {

    //     int count = 0;
    //     String str = Integer.toBinaryString(n);
    //     char[] chars = str.toCharArray();
    //     for (int i = 0; i < chars.length; i++) {
    //         if (chars[i] == '1'){
    //             count++;
    //         }
    //     }
    //     return count;
    // }

    // public int hammingWeight(int n) {

    //     int bits = 0;
    //     int mask = 1;
    //     for (int i = 0; i < 32; i++) {
    //         if ((n & mask) != 0) {
    //             bits++;
    //         }
    //         mask <<= 1;
    //     }
    //     return bits;

    // }


    public int hammingWeight(int n) {

        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;

    }




}