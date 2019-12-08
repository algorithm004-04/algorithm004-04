package week_06.lesson14;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int first = 1,second = 2;
        for (int i = 2; i < n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
