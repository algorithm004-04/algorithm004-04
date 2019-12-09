public class Solution {
    
    //1 Integer bitCount
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
    
    //2 for loop 0 --> 32  %2, /2
    // public int hammingWeight(int n) {
    //     if (n == 0) return 0;
    //     int count = 0;
    //     for(int i = 0 ; i < 32 ; i++) {
    //         if(n%2 == 1) {
    //             count++;
    //         }
    //         n = n/2;
    //     }
    //     return count; 
    // }
    
    //3 for loop 0 --> 32  &1 x = x >> 1
    // public int hammingWeight(int n) {
    //     if (n == 0) return 0;
    //     int count = 0;
    //     int mask = 1;
    //     for(int i = 0 ; i < 32 ; i++) {
    //         if ((n & mask) != 0) {
    //             count++;
    //         }
    //         mask <<= 1;
    //     }
    //     return count; 
    // }
    
    //4 for loop x = x & (x - 1)
    // public int hammingWeight(int n) {
    //     if (n == 0) return 0;
    //     int count = 1;
    //     while ((n &= n - 1) != 0 ) count++;
    //     return count; 
    // }
}