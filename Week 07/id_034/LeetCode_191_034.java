/**
 * LeetCode_191_034
 *
 * @Author blackberry
 * @Date 2019/12/1 10:30 AM
 **/
public class LeetCode_191_034 {

    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            count ++;
            n = n & (n - 1);
        }
        return count;
    }

}
