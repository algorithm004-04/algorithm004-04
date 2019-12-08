package simple;

public class LC191 {

    // you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
        int count = 0;
        while(n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }


}
