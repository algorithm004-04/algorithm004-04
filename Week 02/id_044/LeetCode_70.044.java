package week_02.lesson7;

public class ClimbingStairs {

    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        /*int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = climbStairs(n - 1) + climbStairs( n -2);
        }
        return sum;*/

        int first = 1, second = 2,third;
        for (int j = 3; j <= n; j++) {
            third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(6));
    }

}
