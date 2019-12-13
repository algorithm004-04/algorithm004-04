package week_02.lesson8;

public class Pow {

    public static double myPow(double x, int n) {

        //第一种暴力法，时间为O(n)
        //把x循环乘以n次
        /*long nn = n;
        if (nn < 0) {
            //这段是为了把一个数的负次方转换为正次方
            //x的负n次方=1/x的n次方
            x = 1/x;
            nn = -nn;
        }
        double result = 1;
        for (long i = 0; i < nn; i++) {
            result = result * x;
        }
        return result;*/

        //第二种分治法，时间为O(logn)
        //用递归的方式
        long nn = n;
        if (nn < 0) {
            x = 1 / x;
            nn = -nn;
        }
        return fastPow(x,nn);

    }

    private static double fastPow(double x, long n) {

        if (n == 0) {
            return 1.0;
        }

        double result = fastPow(x, n / 2);
        //算出n是奇数还是偶数，奇数的话要多乘一个自身，偶数的话，两个结果相乘就行了
        return n % 2 == 0 ? result * result : result * result * x;


    }

    public static void main(String[] args) {
        System.out.println(myPow(3, 3));
    }

}
