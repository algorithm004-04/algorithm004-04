package week_03.lesson11;

public class Sqrt {


    public static int mySqrt(int x) {

        //二分法
        /*if (x == 0 || x == 1) {
            return x;
        }
        int left = 1;
        int right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;*/

        //牛顿法1
        /*int s = x;
        if (x == 0 || x == 1) {
            return x;
        }
        return ((int)sqrts(x,s));*/

        //牛顿法2
        int r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return r;
    }

    private static double sqrts(double x,double s) {
        double result = (x + s / x) / 2;
        if (result == x) {
            return x;
        } else {
            return sqrts(result,s);
        }
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(16));
    }

}
