/**
 * LeetCode_338_034
 *
 * @Author blackberry
 * @Date 2019/12/1 11:01 AM
 **/
public class LeetCode_338_034 {

    public int[] countBits(int num) {
        int[] res = new int[num + 1];

        for (int i = 1; i <= num; i ++) {
            res[i] = res[i & i - 1] + 1;
        }
        return res;
    }
}
