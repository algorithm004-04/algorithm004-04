/**
 * Created by Administrator on 2019/12/15 0015.
 */
public class LeetCode_70_爬楼梯 {

    public int climbStairs(int n) {
        return climb_Stairs(0, n);
    }

    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }

}
