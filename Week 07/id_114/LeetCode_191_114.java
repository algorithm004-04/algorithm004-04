public class Solution {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            n = n & (n - 1);
            sum++;
        }
        return sum;
    }
}